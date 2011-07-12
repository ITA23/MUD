package ita23.projekt.mud.rooms;

import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.ItemNotFoundException;

public abstract class BasicRoom {
	
	public BasicRoom(){
		this.initialisieren();
	}
	
	/**
	 * Items welche in diesem Raum gefuden werden können.
	 */
	protected BasicItem[] dinge;
	
	/**
	 * Die Liste der Dingefüllen, etz.
	 */
	public abstract void initialisieren();
	
	/**
	 * Gibt die Story zu diesem Raum als String zurück.
	 * @return
	 */
	public abstract String getStory();
	
	public BasicItem getItem(String name) throws ItemNotFoundException{
		for (BasicItem item : dinge){
			if (item.getName().equalsIgnoreCase(name)){
				item.setInInventar(true);
				return item;
			}
		}
		throw new ItemNotFoundException("Das Item konnte nicht gefunden werden");
	}
	
	public String listItems(){
		StringBuilder b = new StringBuilder();
		String nachricht = "Gegenstände in diesem Raum:\n";
		for (BasicItem item : dinge){
			if (!item.inInventar()) b.append("* "+item.getName()+"\n");
		}
		if (b.length() == nachricht.length()) return "Es befinden sich keine Gegenstände in diesem Raum";
		return b.toString();
	}

}
