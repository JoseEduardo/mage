using System;
using System.Collections;
using System.Collections.Generic;

namespace Models
{
	[Serializable]
	public class ClientCallback
	{
	    public string objectId;
	    public string data;
	    public string method;
	    public int messageId;

		public override string ToString(){
			return UnityEngine.JsonUtility.ToJson (this, true);
		}
	}

	[Serializable]
	public class TableClientMessage
	{
	    public DeckView deck;
	    public string roomId;
	    public string tableId;
	    public string gameId;
	    public string playerId;
	    public int time;
	    public bool flag = false;

		public override string ToString(){
			return UnityEngine.JsonUtility.ToJson (this, true);
		}
	}

	[Serializable]
	public class DeckView
	{
	    public string name;
	    public Dictionary<string, SimpleCardView> cards;
	    public Dictionary<string, SimpleCardView> sideboard;

		public override string ToString(){
			return UnityEngine.JsonUtility.ToJson (this, true);
		}	
	}


	[Serializable]
	public class SimpleCardView
	{
	    public string id;
	    public string expansionSetCode;
	    public string tokenSetCode;
	    public string tokenDescriptor;
	    public string cardNumber;
	    public bool usesVariousArt;
	    public bool gameObject;

		public override string ToString(){
			return UnityEngine.JsonUtility.ToJson (this, true);
		}
	}


}
