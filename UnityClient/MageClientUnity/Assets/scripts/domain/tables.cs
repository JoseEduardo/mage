using System;
using System.Collections;
using System.Collections.Generic;

namespace Models
{
	[Serializable]
	public class Table
	{
		public string tableId;
		public string gameType;
		public string deckType;
		public string tableName;
		public string controllerName;
		public string additionalInfo;
		public int createTime;
		public string tableState;
		public string skillLevel;
		public string tableStateText;
		public string quitRatio;
		public bool limited;
		public bool rated;
		public bool passworded;
		public bool tournament;

		public override string ToString(){
			return UnityEngine.JsonUtility.ToJson (this, true);
		}
	}

	[Serializable]
	public class Tables
	{
 		public List<Table> tables;

		public override string ToString(){
			return UnityEngine.JsonUtility.ToJson (this, true);
		}
	}

}

