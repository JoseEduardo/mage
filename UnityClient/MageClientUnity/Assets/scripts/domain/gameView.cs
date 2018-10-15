using System;
using System.Collections;
using System.Collections.Generic;

namespace Models
{
	[Serializable]
	public class GameView
	{
	    public string objectId;
	    public int priorityTime;
	    public List<PlayerView> players;
	    public Dictionary<string, CardView> hand;
	    public List<string> canPlayInHand;
	    public Dictionary<string, SimpleCardView> opponentHands;
	    public Dictionary<string, SimpleCardView> watchedHands;
	    public Dictionary<string, CardView> stack;
	    public List<ExileView> exiles;
	    public List<RevealedView> revealed;
	    public List<LookedAtView> lookedAt;
	    public List<CombatGroupView> combat;
	    public string phase;
	    public string step;
	    public string activePlayerId;
	    public string activePlayerName = "";
	    public string priorityPlayerName;
	    public int turn;
	    public bool special = false;
	    public bool isPlayer; // false = watching user
	    public int spellsCastCurrentTurn;
	    public bool rollbackTurnsAllowed;

		public override string ToString(){
			return UnityEngine.JsonUtility.ToJson (this, true);
		}
	}

	[Serializable]
	public class UserSkipPrioritySteps
	{
	    public SkipPrioritySteps yourTurn;
	    public SkipPrioritySteps opponentTurn;

	    public bool stopOnDeclareAttackersDuringSkipAction = true;
	    public bool stopOnDeclareBlockerIfNoneAvailable = true;
	    public bool stopOnAllMainPhases = true;
	    public bool stopOnAllEndPhases = true;
	}

	[Serializable]
	public class SkipPrioritySteps
	{
	    public bool upkeep = false;
	    public bool draw = false;
	    public bool main1 = true;
	    public bool beforeCombat = false;
	    public bool endOfCombat = false;
	    public bool main2 = true;
	    public bool endOfTurn = false;
	}

	[Serializable]
	public class Counter
	{
	    public string name;
    	public int count;
	}

	[Serializable]
	public class ManaPoolView
	{
	    public int red;
	    public int green;
	    public int blue;
	    public int white;
	    public int black;
	    public int colorless;
	}

	[Serializable]
	public class CombatGroupView
	{
	    public Dictionary<string, CardView> attackers;
	    public Dictionary<string, CardView> blockers;
	    public string defenderName = "";
	    public string defenderId;

		public override string ToString(){
			return UnityEngine.JsonUtility.ToJson (this, true);
		}
	}

	[Serializable]
	public class LookedAtView
	{
    	public string name;
    	public Dictionary<string, SimpleCardView> cards;

		public override string ToString(){
			return UnityEngine.JsonUtility.ToJson (this, true);
		}
	}

	[Serializable]
	public class RevealedView
	{
    	public string name;
    	public Dictionary<string, CardView> cards;

		public override string ToString(){
			return UnityEngine.JsonUtility.ToJson (this, true);
		}
	}

	[Serializable]
	public class ExileView : CardView
	{
	    public string name;
	    public string id;

		public override string ToString(){
			return UnityEngine.JsonUtility.ToJson (this, true);
		}
	}

	[Serializable]
	public class PermanentView : CardView
	{
	    public bool tapped;
	    public bool flipped;
	    public bool phasedIn;
	    public bool summoningSickness;
	    public int damage;
	    public List<string> attachments;
	    public CardView original;
	    public bool copy;
	    public string nameOwner; // only filled if != controller
	    public bool controlled;
	    public string attachedTo;
	    public bool morphed;
	    public bool manifested;
	    public bool attachedToPermanent;

		public override string ToString(){
			return UnityEngine.JsonUtility.ToJson (this, true);
		}
	}

}