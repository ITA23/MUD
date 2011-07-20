package ita23.projekt.mud.rooms.implementations;

import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.rooms.BasicRoom;

public class Abspann extends BasicRoom{

	@Override
	public void initialisieren() {
		dinge = new BasicItem[0];
	}

	@Override
	public String getStory() {
		return "---------\n\n" +
				"Ende... Vorerst...\n\n" +
				"von \t Lukas Knuth \n" +
				"\t Rafael Marques \n" +
				"\t Fabian Bottler \n" +
				"und \t Marc Bühnert";
	}

}
