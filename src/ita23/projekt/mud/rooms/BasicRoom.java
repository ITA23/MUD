package ita23.projekt.mud.rooms;

import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.ItemNotFoundException;

public abstract class BasicRoom {
	
	/**
	 * Items welche in diesem Raum gefuden werden können.
	 */
	protected BasicItem[] dinge;
	
	/**
	 * Die Liste der Dinge füllen, etz.
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
				item.setHidden(true);
				return item;
			}
		}
		throw new ItemNotFoundException("Das Item konnte nicht gefunden werden");
	}
	
	public String listItems(){
		StringBuilder b = new StringBuilder();
		for (BasicItem item : dinge){
			if (!item.isHidden()) b.append("* "+item.getName()+"\n");
		}
		return b.toString();
	}

}
