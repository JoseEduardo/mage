using UnityEngine;
using UnityEditor;
using Models;
using Proyecto26;
using System.Collections.Generic;
using UnityEngine.SceneManagement;

public class LoginController : MonoBehaviour {
	private string characters = "0123456789abcdefghijklmnopqrstuvwxABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public string basePath = "http://127.0.0.1:9000/";
	private RequestHelper currentRequest;

	private void createSession(){
		currentRequest = new RequestHelper {
			Uri = basePath + "/session/create_session/" + PlayerStats.sessionId,
			Body = new Post {}
		};
		RestClient.Post<Post>(currentRequest)
		.Then(res => connectUser())
		.Catch(err => EditorUtility.DisplayDialog ("Error", err.Message, "Ok"));
	}

	private void connectUser(){
		currentRequest = new RequestHelper {
			Uri = basePath + "/session/connect_user/" + PlayerStats.sessionId + "/password",
			Body = new Post {}
		};
		RestClient.Post<Post>(currentRequest)
		.Then(res => SceneManager.LoadScene("scnTables"))
		.Catch(err => EditorUtility.DisplayDialog ("Error", err.Message, "Ok"));
	}

	public void doLogin() {
		PlayerStats.sessionId = generateSessionId();
		RestClient.DefaultRequestHeaders["Authorization"] = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4bWFnZWRldiJ9.chvKQC9L7tQFUhVsVPk6WbLkyoBOXmmtkbzcsdmY_58";
		createSession();
		SceneManager.LoadScene("scnTables");
	}
 
	 private string generateSessionId () {
		string code = "";
		for (int i = 0; i < 20; i++) {
			int a = Random.Range(0, characters.Length);
			code = code + characters[a];
		}

		return code;
	 }

}
