﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class panelController : MonoBehaviour {

	public GameObject startingPlayerButtons;
	public bool needSelectPlayer = false;
	
	// Update is called once per frame
	void Update () {
		startingPlayerButtons.SetActive(needSelectPlayer);
	}
}
