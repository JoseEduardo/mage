using UnityEngine;
using UnityEditor;
using Models;
using Proyecto26;
using System.Collections;
using System.Collections.Generic;
using UnityEngine.UI;

public class TableController : MonoBehaviour {
	private RequestHelper currentRequest;
    public string basePath = "http://127.0.0.1:9000/";

    public Transform menuPanel;
	public GameObject tableItem;

	public List<CardsList> cardList;
	private DeckList deckList;

	private TableCardList tableCardList;

	private void getTables(){
		currentRequest = new RequestHelper {
			Uri = basePath + "/tables/"
		};

		RestClient.Get(currentRequest).Then(response => {
			Tables lstTables = JsonUtility.FromJson<Tables>(response.Text);
			for(int i = 0; i< lstTables.tables.Count; i++) {
				GameObject itemTable = (GameObject)Instantiate(tableItem);
				itemTable.transform.parent = menuPanel;
				
				itemTable.GetComponentInChildren<InputField>().text = lstTables.tables[i].tableName + " " + lstTables.tables[i].deckType;
				itemTable.GetComponentInChildren<Button>().onClick.AddListener(
					() => {ConnectTable (lstTables.tables[i-1].tableId);}
				);
			}
		});
	}

	private TableCardList demoDeck(){
		cardList.Add(new CardsList {
			cardName =  "Ancient Stirrings",
			setCode =  "ROE",
			cardNum = "174",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Ancient Stirrings",
			setCode =  "ROE",
			cardNum = "174",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Glimmervoid",
			setCode =  "MRD",
			cardNum = "281",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Glimmervoid",
			setCode =  "MRD",
			cardNum = "281",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Glimmervoid",
			setCode =  "MRD",
			cardNum = "281",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Glimmervoid",
			setCode =  "MRD",
			cardNum = "281",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Duress",
			setCode =  "XLN",
			cardNum = "105",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Duress",
			setCode =  "XLN",
			cardNum = "105",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Blooming Marsh",
			setCode =  "KLD",
			cardNum = "243",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Botanical Sanctum",
			setCode =  "KLD",
			cardNum = "244",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Ensnaring Bridge",
			setCode =  "8ED",
			cardNum = "300",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Ensnaring Bridge",
			setCode =  "8ED",
			cardNum = "300",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Mountain",
			setCode =  "RIX",
			cardNum = "195",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Inquisition of Kozilek",
			setCode =  "ROE",
			cardNum = "115",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Inquisition of Kozilek",
			setCode =  "ROE",
			cardNum = "115",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Forest",
			setCode =  "RIX",
			cardNum = "196",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Swamp",
			setCode =  "RIX",
			cardNum = "194",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Grafdigger\u0027s Cage",
			setCode =  "DKA",
			cardNum = "149",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Ghost Quarter",
			setCode =  "ISD",
			cardNum = "240",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Inventors\u0027 Fair",
			setCode =  "KLD",
			cardNum = "247",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Ghoulcaller\u0027s Bell",
			setCode =  "ISD",
			cardNum = "224",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Ghoulcaller\u0027s Bell",
			setCode =  "ISD",
			cardNum = "224",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Ghoulcaller\u0027s Bell",
			setCode =  "ISD",
			cardNum = "224",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Ghoulcaller\u0027s Bell",
			setCode =  "ISD",
			cardNum = "224",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Ghirapur Aether Grid",
			setCode =  "ORI",
			cardNum = "148",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Codex Shredder",
			setCode =  "RTR",
			cardNum = "228",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Codex Shredder",
			setCode =  "RTR",
			cardNum = "228",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Codex Shredder",
			setCode =  "RTR",
			cardNum = "228",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Codex Shredder",
			setCode =  "RTR",
			cardNum = "228",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Fabricate",
			setCode =  "M10",
			cardNum = "52",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Fabricate",
			setCode =  "M10",
			cardNum = "52",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Fabricate",
			setCode =  "M10",
			cardNum = "52",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Spirebluff Canal",
			setCode =  "KLD",
			cardNum = "249",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Sorcerous Spyglass",
			setCode =  "XLN",
			cardNum = "248",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Spire of Industry",
			setCode =  "AER",
			cardNum = "184",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Spire of Industry",
			setCode =  "AER",
			cardNum = "184",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Spire of Industry",
			setCode =  "AER",
			cardNum = "184",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Spire of Industry",
			setCode =  "AER",
			cardNum = "184",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Ethersworn Canonist",
			setCode =  "ALA",
			cardNum = "10",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Ajani Vengeant",
			setCode =  "ALA",
			cardNum = "154",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Lantern of Insight",
			setCode =  "5DN",
			cardNum = "135",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Lantern of Insight",
			setCode =  "5DN",
			cardNum = "135",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Lantern of Insight",
			setCode =  "5DN",
			cardNum = "135",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Lantern of Insight",
			setCode =  "5DN",
			cardNum = "135",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Academy Ruins",
			setCode =  "TSP",
			cardNum = "269",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Extirpate",
			setCode =  "PLC",
			cardNum = "71",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Spellskite",
			setCode =  "NPH",
			cardNum = "159",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Abrupt Decay",
			setCode =  "RTR",
			cardNum = "141",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Welding Jar",
			setCode =  "MRD",
			cardNum = "274",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Witchbane Orb",
			setCode =  "ISD",
			cardNum = "236",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Elixir of Immortality",
			setCode =  "M14",
			cardNum = "209",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Plains",
			setCode =  "ARENA",
			cardNum = "23",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Mishra\u0027s Bauble",
			setCode =  "CSP",
			cardNum = "138",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Mishra\u0027s Bauble",
			setCode =  "CSP",
			cardNum = "138",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Mishra\u0027s Bauble",
			setCode =  "CSP",
			cardNum = "138",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Mishra\u0027s Bauble",
			setCode =  "CSP",
			cardNum = "138",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Galvanic Blast",
			setCode =  "SOM",
			cardNum = "91",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Galvanic Blast",
			setCode =  "SOM",
			cardNum = "91",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Galvanic Blast",
			setCode =  "SOM",
			cardNum = "91",
			quantity = 1
		});
		cardList.Add(new CardsList {
			cardName =  "Galvanic Blast",
			setCode =  "SOM",
			cardNum = "91",
			quantity = 1
		});

		deckList = new DeckList{
			name = "Name",
			author = "Autor",
			password = "",
	 		cards = cardList
		};

		tableCardList = new TableCardList {
			name = "teste",
			playerType = "HUMAN",
			skill = 0,
			deckList = deckList
		};
		return tableCardList;
	}

	private void createSession(string tableId) {
		currentRequest = new RequestHelper {
			Uri = basePath + "/tables/join_table/" + tableId,
			Body = demoDeck()
		};
		RestClient.Post(currentRequest)
		.Catch(err => Debug.Log("ERROR"));
	}


	void ConnectTable(string tableId) {
	 	createSession(tableId);
	}

	void Start () {
		getTables();
	}

}
