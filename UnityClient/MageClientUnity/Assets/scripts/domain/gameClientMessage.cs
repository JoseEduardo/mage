using System;
using System.Collections;
using System.Collections.Generic;

namespace Models
{
	[Serializable]
	public class GameClientMessage
	{
	    public GameView gameView;
	    public Dictionary<string, CardView> cardsView;
	    public Dictionary<string, CardView> cardsView2;
	    public string message;
	    public bool flag;
	    public List<string> strings;
	    public List<string> targets;
	    public int min;
	    public int max;
	    public GameOptions options;
	    public string choice;

		public override string ToString(){
			return UnityEngine.JsonUtility.ToJson (this, true);
		}
	}

	[Serializable]
	public class GameOptions
	{
	    public string queryType;

		public override string ToString(){
			return UnityEngine.JsonUtility.ToJson (this, true);
		}
	}

}