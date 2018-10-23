using UnityEngine;
using UnityEditor;
using Models;
using Proyecto26;
using System.Collections;
using System.Collections.Generic;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class GameController : MonoBehaviour {
	private RequestHelper currentRequest;
    public string basePath = "http://127.0.0.1:9000/";

	private void joinGame(){
		currentRequest = new RequestHelper {
			Uri = basePath + "/games/join_game/" + PlayerStats.gameId
		};

		RestClient.Post(currentRequest);
	}

	// Use this for initialization
	void Start () {
		joinGame();
	}
	
	// Update is called once per frame
	void Update () {
		
	}
}
