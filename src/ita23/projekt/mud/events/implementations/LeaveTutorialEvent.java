package ita23.projekt.mud.events.implementations;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.rooms.BasicRoom;

/**
 * Event welches das Tutorial verlässt.
 * @author Lukas Knuth
 *
 */
public class LeaveTutorialEvent extends BasicEvent{
	
	/** Die Nachricht welche beim beenden des
	 * Tutorials angezeigt wird.
	 */
	private String msg;
	/** Das nächste Level nach dem Tutorial */
	private BasicRoom level;
	
	/**
	 * Löst das Event aus und setzt die Nachtricht und
	 *  das nächste Level.
	 * @param msg Die Nachricht welche beim verlassen des
	 *  Tutorials angezeigt wird
	 * @param level Das Level welches nach dem Tutorial
	 *  gespielt werden soll.
	 */
	public LeaveTutorialEvent(String msg, BasicRoom level){
		super();
		this.msg = msg;
		this.level = level;
	}

	@Override
	public String getEventMessage() {
		return msg + "\n\n" + level.getStory();
	}

	@Override
	public void doEvent() {
		// Betrete den Normalen Spiel-modus
		game.leaveTutorial();
		// Wechle das Level:
		game.setLevel(level);
	}

}
