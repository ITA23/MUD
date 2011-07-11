package ita23.projekt.mud.rooms.implementations;

import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.implementations.Blutwurst;
import ita23.projekt.mud.rooms.BasicRoom;

public class StartRoom extends BasicRoom{
	
	public StartRoom(){
		this.initialisieren();
	}

	@Override
	public void initialisieren() {
		this.dinge = new BasicItem[1];
		dinge[0] = new Blutwurst();
	}

	@Override
	public String getStory() {
		return "Inspector Mo und Detective Zeitraffa betreten zielstrebig die große Halle am Ende " +
				"des Flurs. Es richt ein wenig nach Schießpulver als die Türe langsam ins Schloss fällt.";
	}

}