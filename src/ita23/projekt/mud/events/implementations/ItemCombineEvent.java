package ita23.projekt.mud.events.implementations;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.items.BasicItem;

/**
 * Wird verwendet um ein Event zu erstellen, welches
 * beim Kombinieren von zwei Items ausgelöst wird.
 * @author Lukas Knuth
 *
 */
public class ItemCombineEvent extends BasicEvent{
	
	/** Das erste Item, welches bei diesem Event benutzt wird */
	private BasicItem i1;
	/** Das zweite Item, welches bei diesem Event benutzt wird */
	private BasicItem i2;
	/** Das neue Item welches durch die Kombination der beiden
	 * alten Items entsteht.
	 */
	private BasicItem nI;
	/** Die Nachricht die angezeigt wird, wenn die beiden Items
	 * erfolgreich miteinander kombiniert werden.
	 */
	private String message;
	
	/**
	 * Kombiniert zwei Items miteinander und setzt eine Standart-
	 *  Nachticht ein.
	 * @param item1 Das erste zu kombinierende Item
	 * @param item2 Das zweite zu kombinierende Item
	 * @param newItem Das Item welches durch die Kombination erstellt wird.
	 */
	public ItemCombineEvent(BasicItem item1, BasicItem item2, BasicItem newItem){
		super();
		this.i1 = item1;
		this.i2 = item2;
		this.nI = newItem;
		this.message = null;
	}
	
	/**
	 * Kombiniert zwei Items miteinander
	 * @param item1 Das erste zu kombinierende Item
	 * @param item2 Das zweite zu kombinierende Item
	 * @param newItem Das Item welches durch die Kombination erstellt wird.
	 * @param message Die Nachricht, welche bei der Kombination der Items
	 *  angezeigt wird.
	 */
	public ItemCombineEvent(BasicItem item1, BasicItem item2, BasicItem newItem, String message){
		super();
		this.i1 = item1;
		this.i2 = item2;
		this.nI = newItem;
		this.message = message;
	}

	/**
	 * Gibt eine Nachricht für die Kombination der beiden
	 * Items zurück.
	 */
	@Override
	public String getEventMessage() {
		if (message == null){
			return "Du hast "+i1.getName()+" mit "+i2.getName()+" kombiniert und "+nI.getName()+" erhalten!";
		}
		return message;
	}

	/**
	 * Löscht die beiden benutzten Items aus dem Inventar
	 * und fügt das neue Item hinzu.
	 */
	@Override
	public void doEvent() {
		// Entferne die alten Itrems:
		game.inventar.remove(i1.getName().toUpperCase());
		game.inventar.remove(i2.getName().toUpperCase());
		// Füge neues Hinzu:
		game.inventar.put(nI.getName().toUpperCase(), nI);
	}

}
