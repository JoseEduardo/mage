using UnityEngine;
using System.Collections;
using UnityEngine.EventSystems;

public class DropZone : MonoBehaviour, IDropHandler, IPointerEnterHandler, IPointerExitHandler {

	public GameObject cardPlaced = null;
	public Transform placePermanent = null;

	public void OnPointerEnter(PointerEventData eventData) {
		Debug.Log("OnPointerEnter");
		if(eventData.pointerDrag == null)
			return;

		Draggable d = eventData.pointerDrag.GetComponent<Draggable>();
		if(d != null) {
			d.placeholderParent = this.transform;
		}
	}
	
	public void OnPointerExit(PointerEventData eventData) {
		Debug.Log("OnPointerExit");
		if(eventData.pointerDrag == null)
			return;

		Draggable d = eventData.pointerDrag.GetComponent<Draggable>();
		if(d != null && d.placeholderParent==this.transform) {
			d.placeholderParent = d.parentToReturnTo;
		}
	}
	
	public void OnDrop(PointerEventData eventData) {
		Debug.Log (eventData.pointerDrag.name + " was dropped on " + gameObject.name);

		Draggable d = eventData.pointerDrag.GetComponent<Draggable>();
		if(d != null) {
			d.parentToReturnTo = this.transform;
		}

		//if(!cardPlaced){
			GameObject cardPlacedInst = Instantiate(cardPlaced);
			cardPlacedInst.transform.SetParent( placePermanent, false );
		//}
		/*
		eventData.pointerDrag.transform.eulerAngles = new Vector3(
		    this.transform.eulerAngles.x,
		    eventData.pointerDrag.transform.eulerAngles.y,
		    eventData.pointerDrag.transform.eulerAngles.z
		);
		*/
	}
}
