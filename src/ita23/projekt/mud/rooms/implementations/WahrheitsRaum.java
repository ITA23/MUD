package ita23.projekt.mud.rooms.implementations;

import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.rooms.BasicRoom;

public class WahrheitsRaum extends BasicRoom{

	@Override
	public void initialisieren() {
		this.dinge = new BasicItem[1];
		
	}

	@Override
	public String getStory() {
		return "-- Die Wahrheit über Prof. Dr. NicoX --\n" +
				"";
	}

}
