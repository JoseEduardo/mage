using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Proyecto26;

[Serializable]
public static class PlayerConectionController {
	private static RequestHelper currentRequest;

	public static void doSendUuid(string uuid){
		currentRequest = new RequestHelper {
			Uri = PlayerStats.basePath + "/games/" + PlayerStats.gameId + "/send_uuid/" + uuid
		};

		RestClient.Put(currentRequest)
		.Then(response => {
		});
	}

	public static void doSendBoolean(bool value){
		currentRequest = new RequestHelper {
			Uri = PlayerStats.basePath + "/games/" + PlayerStats.gameId + "/send_boolean/" + value
		};

		RestClient.Put(currentRequest)
		.Then(response => {
		});
	}

}