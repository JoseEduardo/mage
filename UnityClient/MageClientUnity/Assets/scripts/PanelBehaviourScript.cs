using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PanelBehaviourScript : MonoBehaviour {


	public void leftButtonPress(){
		Debug.Log("AAAA");
		PlayerConectionController.doSendBoolean(true);
		PlayerStats.needAskPlayer = false;
 	}

	public void rightButtonPress(){
		PlayerConectionController.doSendBoolean(false);
		PlayerStats.needAskPlayer = false;
 	}
}
