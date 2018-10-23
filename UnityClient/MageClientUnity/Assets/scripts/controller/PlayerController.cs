using Models;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using SimpleJSON;

public class PlayerController : MonoBehaviour {

	public string player1Id;
	public string player2Id;

	public GameObject stack;
	public GameObject hand;
	public GameObject cardPrefab;

	public void populateHand (SimpleJSON.JSONNode handInGame) {
		foreach(Transform child in hand.transform) {
    		Destroy(child);
		}

		foreach(var item in handInGame) {
			GameObject cardPlacedInst = Instantiate(cardPrefab);
			CardController cardControllerInst = cardPlacedInst.GetComponent<CardController>();
			cardControllerInst.setCardId(item.Key);
			cardPlacedInst.transform.SetParent( hand.transform, false );
		}

	}

	public void populateStack(SimpleJSON.JSONNode stackInGame) {

	}
	
	// Update is called once per frame
	void Update () {
		
	}
}
