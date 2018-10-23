using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SelectPlayerBehaviour : MonoBehaviour {
	public string referenceId;

	public void changeReferenceId(string newReference){
		referenceId = newReference;
	}

	void OnMouseDown(){
		PlayerConectionController.doSendUuid(referenceId);
		PlayerStats.needAskPlayer = false;
 	}
}
