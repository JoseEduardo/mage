using UnityEngine;
using UnityEditor;
using Models;
using Proyecto26;
using System.Collections;
using System.Collections.Generic;
using UnityEngine.UI;
using UnityEngine.SceneManagement;
using SimpleJSON;

public class CallbackController : MonoBehaviour {
	private RequestHelper currentRequest;
    public string basePath = "http://127.0.0.1:9000/";

    public PlayerController playerController;

	private void getCallback(){
		currentRequest = new RequestHelper {
			Uri = basePath + "/session/get_callback/" + PlayerStats.sessionId
		};

		RestClient.Get(currentRequest)
		.Then(response => {
			//Debug.Log(response.Text);
			ClientCallback callback = JsonUtility.FromJson<ClientCallback>(response.Text);
			executeCallback(callback);
		});
	}
	
	private void markReadCallback(){
		currentRequest = new RequestHelper {
			Uri = basePath + "/session/clear_callback/" + PlayerStats.sessionId
		};

		RestClient.Post(currentRequest);
	}

	void Update () {
		getCallback();
	}

	void executeCallback(ClientCallback callback) {
		Debug.Log(callback.method);
		switch (callback.method) {
            case "JOINED_TABLE": {
                TableClientMessage message =  JsonUtility.FromJson<TableClientMessage>(callback.data);
                //joinedTable(message.getRoomId(), message.getTableId(), message.getFlag());
                markReadCallback();
                break;
            }
            case "START_GAME": {
                TableClientMessage message =  JsonUtility.FromJson<TableClientMessage>(callback.data);
                PlayerStats.gameId = message.gameId;
                markReadCallback();
				SceneManager.LoadScene("scnGame");
                break;
            }
            case "GAME_INIT": {
                GameView message =  JsonUtility.FromJson<GameView>(callback.data);
/*
           		Debug.Log(message);
          		Debug.Log(callback.data);
*/
				markReadCallback();
                break;
            }
            case "GAME_INFORM": {
                GameView message =  JsonUtility.FromJson<GameView>(callback.data);
                Debug.Log(callback.data);
/*
           		Debug.Log(message);
          		Debug.Log(callback.data);
*/
                break;
            }
            case "GAME_TARGET": {
                markReadCallback();
                GameClientMessage message =  JsonUtility.FromJson<GameClientMessage>(callback.data);

                if(message.options.queryType == "PICK_TARGET"){
                    PlayerStats.needSelectPlayer = true;
                    SelectPlayerBehaviour player1Slc = GameObject.Find("player1Select").GetComponent<SelectPlayerBehaviour>();
                    SelectPlayerBehaviour player2Slc = GameObject.Find("player2Select").GetComponent<SelectPlayerBehaviour>();
                    player1Slc.changeReferenceId(message.targets[0]);
                    player2Slc.changeReferenceId(message.targets[1]);
                    PlayerStats.message = message.message;
                }
                break;
            }
            case "GAME_ASK": {
                markReadCallback();
                Debug.Log(callback.data);
                var message = JSON.Parse(callback.data);
                playerController.populateHand(message["gameView"]["hand"]);

                if(message["options"]["queryType"] == "ASK"){
                    PlayerStats.needAskPlayer = true;

                    PlayerStats.message = message["message"];
                    PlayerStats.rightBtn = message["options"]["UI.right.btn.text"];
                    PlayerStats.leftBtn = message["options"]["UI.left.btn.text"];
                }

                /*
                GameClientMessage message =  JsonUtility.FromJson<GameClientMessage>(callback.data);
                Debug.Log(callback.data);
                Debug.Log(message.gameView);
                */
                break;
            }
        }
	}
}
