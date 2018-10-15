using System;
using System.Collections;
using System.Collections.Generic;


namespace Models
{

	[Serializable]
	public class CardView : SimpleCardView
	{
	    public string parentId;
	    public string name;
	    public string displayName;
	    public List<string> rules;
	    public string power;
	    public string toughness;
	    public string loyalty = "";
	    public string startingLoyalty;
	    public string cardTypes;
	    public string subTypes;
	    public string superTypes;
	    public string color;
	    public string frameColor;
	    public string frameStyle;
	    public List<string> manaCost;
	    public int convertedManaCost;
	    public string rarity;

	    public string mageObjectType;

	    public bool isAbility;
	    public string abilityType;
	    public bool isToken;

	    public CardView ability;
	    public int type;

	    public bool transformable;
	    public CardView secondCardFace;
	    public bool transformed;

	    public bool flipCard;
	    public bool faceDown;

	    public string alternateName;
	    public string originalName;

	    public bool isSplitCard;
	    public string leftSplitName;
	    public string leftSplitCosts; //ManaCosts
	    public List<string> leftSplitRules;
	    public string leftSplitTypeLine;
	    public string rightSplitName;
	    public string rightSplitCosts; //ManaCosts
	    public List<string> rightSplitRules;
	    public string rightSplitTypeLine;

	    public string artRect;

	    public List<string> targets;

	    public string pairedCard;
	    public List<string> bandedCards;
	    public bool paid;
	    public List<Counter> counters;

	    public bool controlledByOwner = true;

	    public string zone;

	    public bool rotate;
	    public bool hideInfo; // controls if the tooltip window is shown (eg. controlled face down morph card)

	    public bool isPlayable;
	    public bool isChoosable;
	    public bool selected;
	    public bool canAttack;
	    public bool inViewerOnly;

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