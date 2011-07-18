package ita23.projekt.mud.rooms.implementations;

import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.rooms.BasicRoom;

public class Home extends BasicRoom{

	@Override
	public void initialisieren() {
		this.dinge = new BasicItem[0];
	}

	@Override
	public String getStory() {
		return "> \"Was für ein scheiß Spiel...\"";
	}

}
