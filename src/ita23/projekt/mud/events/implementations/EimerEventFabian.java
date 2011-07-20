package ita23.projekt.mud.events.implementations;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.items.BasicItem;

/**
 * Wird speziell für das Eimer Rätzel verwendet
 * @author Fabian Bottler
 *
 */
public class EimerEventFabian extends BasicEvent  {
	
	/** Der 3L Eimer*/
	private BasicItem i1;
	/** Der 5L Eimer*/
	private BasicItem i2;
	/** Der neu gefüllte Eimer*/
	private BasicItem nI;
	/** Ein zweiter neuer Eimer */
	private BasicItem nI2;
	/** Angaben zum neuen Eimer*/
	private String message;
	
	/**
	 * Füllte den einen Eimer mit dem anderen
	 * @param item1 Der 3L Eimer
	 * @param item2 Der 5L eimer
	 * @param newItem Der neu gefüllte Eimer.
	 * @param message Angbe wie voll der Eimer ist.
	 */
	public EimerEventFabian(BasicItem item1, BasicItem item2, BasicItem newItem, String message){
		super();
		this.i1 = item1;
		this.i2 = item2;
		this.nI = newItem;
		this.message = message;
		
	}
	
	/**
	 * Füllt Eimer
	 * @param item1 Der 3L Eimer
	 * @param item2 Der 5L eimer
	 * @param newItem Der neu gefüllte Eimer.
	 * @param newItem2 Der zweite neue Eimer.
	 * @param message Angbe wie voll der Eimer ist.
	 */
	public EimerEventFabian(BasicItem item1, BasicItem item2, BasicItem newItem, BasicItem newItem2, String message){
		super();
		this.i1 = item1;
		this.i2 = item2;
		this.nI2=newItem2;
		this.nI = newItem;
		this.message = message;
		
	}

	@Override
	public String getEventMessage() {
		return message;
	}

	@Override
	public void doEvent() {
		game.inventar.remove(i2.getName().toUpperCase());
		game.inventar.put(nI.getName().toUpperCase(), nI);
		game.inventar.put(nI2.getName().toUpperCase(), nI);
	}

}
