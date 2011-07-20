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
	/** Angaben zum neuen Eimer*/
	private String message;
	/**
	 * Füllte den einen Eimer mit dem anderen
	 * @param Der 3L Eimer
	 * @param Der 5L eimer
	 * @param Der neu gefüllte Eimer.
	 * @param Angbe wie voll der Eimer ist.
	 */
	public EimerEventFabian(BasicItem item1, BasicItem item2, BasicItem newItem, String message){
		super();
		this.i1 = item1;
		this.i2 = item2;
		this.nI = newItem;
		this.message = message;
		
	}

	@Override
	public String getEventMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doEvent() {
		game.inventar.remove(i2.getName().toUpperCase());
		game.inventar.put(nI.getName().toUpperCase(), nI);
		
	}

}
