using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SelectPlayerBehaviour : MonoBehaviour {
	public string referenceId;

	void OnMouseDown(){
		PlayerController.doSendUuid(referenceId);
 	}
}
