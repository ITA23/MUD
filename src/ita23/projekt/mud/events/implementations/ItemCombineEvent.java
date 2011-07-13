package ita23.projekt.mud.events.implementations;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.items.BasicItem;

public class ItemCombineEvent extends BasicEvent{
	
	private BasicItem i1;
	private BasicItem i2;
	private BasicItem nI;
	private String message;
	
	public ItemCombineEvent(BasicItem item1, BasicItem item2, BasicItem newItem){
		super();
		this.i1 = item1;
		this.i2 = item2;
		this.nI = newItem;
		this.message = null;
	}
	
	public ItemCombineEvent(BasicItem item1, BasicItem item2, BasicItem newItem, String message){
		super();
		this.i1 = item1;
		this.i2 = item2;
		this.nI = newItem;
		this.message = message;
	}

	@Override
	public String getEventMessage() {
		if (message == null){
			return "Du hast "+i1.getName()+" mit "+i2.getName()+" kombiniert und "+nI.getName()+" erhalten!";
		}
		return message;
	}

	@Override
	public void doEvent() {
		// Entferne die alten Itrems:
		game.inventar.remove(i1.getName().toUpperCase());
		game.inventar.remove(i2.getName().toUpperCase());
		// Füge neues Hinzu:
		game.inventar.put(nI.getName().toUpperCase(), nI);
	}

}
