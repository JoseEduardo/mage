using System;
using System.Collections;
using System.Collections.Generic;

namespace Models
{
	[Serializable]
	public class TableCardList
	{
		public string name;
		public string playerType;
		public int skill;
		public DeckList deckList;

		public override string ToString(){
			return UnityEngine.JsonUtility.ToJson (this, true);
		}
	}

	[Serializable]
	public class DeckList
	{
		public string name;
		public string author;
		public string password;
 		public List<CardsList> cards;
 		public List<CardsList> sideboard;

		public override string ToString(){
			return UnityEngine.JsonUtility.ToJson (this, true);
		}
	}

	[Serializable]
	public class CardsList
	{
		public string cardName;
		public string setCode;
		public string cardNum;
		public int quantity;

		public override string ToString(){
			return UnityEngine.JsonUtility.ToJson (this, true);
		}
	}

}

