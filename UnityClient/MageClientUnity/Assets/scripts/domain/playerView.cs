using System;
using System.Collections;
using System.Collections.Generic;

namespace Models
{
	[Serializable]
	public class PlayerView
	{
	    public string playerId;
	    public string name;
	    public int life;
	    public Dictionary<string, Counter> counters;
	    public int wins;
	    public int winsNeeded;
	    public long deckHashCode;
	    public int libraryCount;
	    public int handCount;
	    public bool isActive;
	    public bool hasPriority;
	    public bool timerActive;
	    public bool hasLeft;
	    public ManaPoolView manaPool;
	    public Dictionary<string, CardView> graveyard;
	    public Dictionary<string, CardView> exile;
	    public Dictionary<string, PermanentView> battlefield;
	    public CardView topCard;
	    public UserData userData;
	    public List<string> commandList; //CommandObjectView
	    public List<string> attachments;
	    public int statesSavedSize;
	    public int priorityTimeLeft;
	    public bool passedTurn; // F4
	    public bool passedUntilEndOfTurn; // F5
	    public bool passedUntilNextMain; // F6
	    public bool passedUntilStackResolved; // F8
	    public bool passedAllTurns; // F9
	    public bool passedUntilEndStepBeforeMyTurn; // F11
	    public bool monarch;
	    public List<string> designationNames;
	}

	[Serializable]
	public class UserData
	{
	    public int groupId;
	    public int avatarId;
	    public bool showAbilityPickerForced;
	    public bool allowRequestShowHandCards;
	    public bool confirmEmptyManaPool;
	    public UserSkipPrioritySteps userSkipPrioritySteps;
	    public string flagName;
	    public bool askMoveToGraveOrder;
	    public bool manaPoolAutomatic;
	    public bool manaPoolAutomaticRestricted;
	    public bool passPriorityCast;
	    public bool passPriorityActivation;
	    public bool autoOrderTrigger;
	    public bool useFirstManaAbility;
	    public string userIdStr;

	    public string matchHistory;
	    public int matchQuitRatio;
	    public string tourneyHistory;
	    public int tourneyQuitRatio;

	    public int generalRating;
	    public int constructedRating;
	    public int limitedRating;
	}

}