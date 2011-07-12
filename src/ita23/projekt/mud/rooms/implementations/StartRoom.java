package ita23.projekt.mud.rooms.implementations;

import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.implementations.Blutwurst;
import ita23.projekt.mud.items.implementations.Gummiente;
import ita23.projekt.mud.items.implementations.Schwarzpulver;
import ita23.projekt.mud.items.implementations.Seil;
import ita23.projekt.mud.rooms.BasicRoom;

public class StartRoom extends BasicRoom{
	
	@Override
	public void initialisieren() {
		this.dinge = new BasicItem[4];
		dinge[0] = new Blutwurst();
		dinge[1] = new Gummiente();
		dinge[2] = new Schwarzpulver();
		dinge[3] = new Seil();
	}

	@Override
	public String getStory() {
		return "Inspector Mo und Detective Zeitraffa betreten zielstrebig die große Halle am Ende " +
				"des Flurs. Es richt ein wenig nach Schießpulver als die Türe langsam ins Schloss fällt.";
	}

}