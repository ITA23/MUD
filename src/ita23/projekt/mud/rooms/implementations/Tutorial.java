package ita23.projekt.mud.rooms.implementations;

import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.tutorial.Magazin;
import ita23.projekt.mud.rooms.BasicRoom;

/**
 * Start-Raum, in welchem das Tutorial stat findet.
 * @author Lukas Knuth
 *
 */
public class Tutorial extends BasicRoom{

	@Override
	public void initialisieren() {
		this.dinge = new BasicItem[1];
		dinge[0] = new Magazin();
	}

	@Override
	public String getStory() {
		return "*bam * *bums * * ratta ratta *\n" +
				"Etwa zwei Meter neben mir detoniert eine Handgranate. " +
				"Einen Moment lang verliere ich die Orientierung und schaue mich verwirrt um. " +
				"Um mich herum scheinen die Leute zu sterben wie die Fliegen.\n\n" +
				"  Geben Sie \"hilfe\" ein, um eine Übersicht aller möglichen Befehle zu erhalten.";
	}

}
