package ita23.projekt.mud.items;

import ita23.projekt.mud.events.BasicEvent;

public abstract class BasicItem {
	
	private boolean inInventar = false;
	
	/**
	 * Gibt den Namen des Items zurück
	 * @return Der Name des Items
	 */
	public abstract String getName();
	
	/**
	 * Löst ein Event aus wenn ein bestimmtes Item mit diesem Item
	 * kombiniert wird
	 * @param item Das Item welches mit diesem Item kombiniert werden soll
	 * @return Das ausgelöste Event
	 * @throws CantUseItemException Wenn die beiden Items nicht miteinander
	 *  kombiniert werden können.
	 */
	public abstract BasicEvent use(BasicItem item) throws CantUseItemException;
	
	public boolean inInventar(){
		return inInventar;
	}
	
	public void setInInventar(boolean value){
		this.inInventar = value;
	}

}
