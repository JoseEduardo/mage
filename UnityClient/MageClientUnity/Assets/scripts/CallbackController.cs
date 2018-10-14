﻿using UnityEngine;
using UnityEditor;
using Models;
using Proyecto26;
using System.Collections;
using System.Collections.Generic;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class CallbackController : MonoBehaviour {
	private RequestHelper currentRequest;
    public string basePath = "http://127.0.0.1:9000/";

	private void getCallback(){
		currentRequest = new RequestHelper {
			Uri = basePath + "/session/get_callback/" + PlayerStats.sessionId,
			Body = new Post {}
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
			Uri = basePath + "/session/clear_callback/" + PlayerStats.sessionId,
			Body = new Post {}
		};

		RestClient.Post(currentRequest);
	}

	void Update () {
		getCallback();
	}

	void executeCallback(ClientCallback callback) {
		Debug.Log(callback.method);
		switch (callback.method) {
            case "START_GAME": {
                TableClientMessage message =  JsonUtility.FromJson<TableClientMessage>(callback.data);
                markReadCallback();
				SceneManager.LoadScene("scnGame");
                break;
            }
            case "JOINED_TABLE": {
                TableClientMessage message =  JsonUtility.FromJson<TableClientMessage>(callback.data);
           		Debug.Log(callback);
           		Debug.Log(message);
                //joinedTable(message.getRoomId(), message.getTableId(), message.getFlag());
                //PlayerStats.gameId = message.gameId;
           		Debug.Log(message.gameId);
                markReadCallback();
                break;
            }
        }
	}
}
