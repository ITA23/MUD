package ita23.projekt.mud.items;

import ita23.projekt.mud.events.BasicEvent;

/**
 * Basisklasse für ein Item, welches sich in einem
 * Raum befinden und benutzt werden kann.
 * @author Lukas Knuth
 *
 */
public abstract class BasicItem {
	
	/** Wird benutzt, um Items welche sich im Inventar des
	 * Spielers benutzten nicht mehr im Raum an zu zeigen.
	 */
	private boolean inInventar = false;
	
	/**
	 * Gibt den Namen des Items zurück
	 * @return Der Name des Items
	 */
	public abstract String getName();
	
	/**
	 * Gibt genauere Informationen zu diesem Gegenstand
	 *  als String zurück.
	 * @return Die genaueren Informationen als String
	 */
	public abstract String getInspectString();
	
	/**
	 * Gibt an ob dieses Item in das Inventar aufgenommen
	 *  werden kann.
	 * @return "true" wenn ja, sonst "false".
	 */
	public abstract boolean isTakeable();
	
	/**
	 * Löst ein Event aus wenn ein bestimmtes Item mit diesem Item
	 * kombiniert wird
	 * @param item Das Item welches mit diesem Item kombiniert werden soll
	 * @return Das ausgelöste Event
	 * @throws CantUseItemException Wenn die beiden Items nicht miteinander
	 *  kombiniert werden können.
	 */
	public abstract BasicEvent use(BasicItem item) throws CantUseItemException;
	
	/**
	 * Fragt ab, ob sich dieses Item im Inventar des Spielers
	 * befindet.
	 * @return "true", wenn sich das Item im Inventar befindet.
	 *  Sonst "false".
	 */
	public boolean inInventar(){
		return inInventar;
	}
	
	/**
	 * Setzt das Item in das Inventar oder nimmt es wieder
	 *  heraus.
	 * @param value Legt fest, ob das Item zum Inventar
	 *  hinzu gefügt wird.
	 */
	public void setInInventar(boolean value){
		this.inInventar = value;
	}

}
