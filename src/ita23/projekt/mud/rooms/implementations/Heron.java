package ita23.projekt.mud.rooms.implementations;

import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.implementations.Heron.*;
import ita23.projekt.mud.rooms.BasicRoom;

/**
 * Heron von Alexandria, NR.73
 * @author Fabian Bottler
 *
 */
public class Heron extends BasicRoom{

	@Override
	public void initialisieren() {
		this.dinge = new BasicItem[2];
		dinge[0] = new Fackel();
		dinge[1] = new Opferfeuer();
	}

	@Override
	public String getStory() {
		return "Der Raum wird von einer Fackel erhellt und erleuchtet eine Automaten \n" +
				" aus der Antike von Heron von Alexandria . \n" +
				"Nur das erloschene Opferfeuer, \n" +
				"der Antiken Maschine, ist zu sehen.";
	}

}
