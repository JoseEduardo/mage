using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public static class PlayerController {
	private RequestHelper currentRequest;

	public void doSendUuid(string uuid){
		currentRequest = new RequestHelper {
			Uri = PlayerStats.basePath + "/games/" + PlayerStats.gameId + "/send_uuid/" + uuid
		};

		RestClient.Post(currentRequest)
		.Then(response => {
		});
	}
}