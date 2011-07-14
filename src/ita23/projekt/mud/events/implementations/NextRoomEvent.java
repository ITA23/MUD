package ita23.projekt.mud.events.implementations;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.rooms.BasicRoom;

/**
 * Event welches ausgelöst wird, wenn der Spieler einen
 *  Raum beendet hat.
 * @author Lukas Knuth
 *
 */
public class NextRoomEvent extends BasicEvent{
	
	/** Die Nachricht, welche wechseln des Raumes
	 * ausgegeben wird.
	 */
	private String message;
	/** Der Raum, welcher als nächstes gelöst werden
	 * muss.
	 */
	private BasicRoom room;
	
	/**
	 * Setzt die ausgegebene Nachricht und den neuen Raum
	 * @param message Die Nachricht welche ausgegeben werden
	 *  soll.
	 * @param room Der Raum, welcher als nächstes gelöst
	 *  werden muss.
	 */
	public NextRoomEvent(String message, BasicRoom room){
		this.message = message;
		this.room = room;
	}

	/**
	 * Gibt die Nachricht zum wechsel des Raumes und die
	 *  Story des neuen Raums zusammen zurück.
	 */
	@Override
	public String getEventMessage() {
		return message + "\n\n" + room.getStory();
	}

	/**
	 * Ändert das aktuelle Level des "Game"-Objekts.
	 */
	@Override
	public void doEvent() {
		game.setLevel(room);
	}

}
