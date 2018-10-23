using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class panelController : MonoBehaviour {

	public GameObject startingPlayerButtons;
	public GameObject rightBtn;
	public GameObject leftBtn;
	public GameObject message;
	public GameObject panelAsk;
	public GameObject boardPerm;
	
	// Update is called once per frame
	void Update () {
		if(PlayerStats.needSelectPlayer) {
			startingPlayerButtons.SetActive(PlayerStats.needSelectPlayer);
			boardPerm.SetActive(!PlayerStats.needSelectPlayer);
		} else {
			panelAsk.SetActive(PlayerStats.needAskPlayer);
			boardPerm.SetActive(!PlayerStats.needAskPlayer);
			rightBtn.GetComponentInChildren<Text>().text = PlayerStats.rightBtn;
			leftBtn.GetComponentInChildren<Text>().text = PlayerStats.leftBtn;
			message.GetComponentInChildren<Text>().text = PlayerStats.message;
		}
	}
}
