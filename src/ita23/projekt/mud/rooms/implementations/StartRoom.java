package ita23.projekt.mud.rooms.implementations;

import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.implementations.room1.Blutwurst;
import ita23.projekt.mud.items.implementations.room1.Gummiente;
import ita23.projekt.mud.items.implementations.room1.Schwarzpulver;
import ita23.projekt.mud.items.implementations.room1.Seil;
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
		return  ">------ Prolog ------<\n" +
				"1990 Bukarest(Rumänien)\n" +
				"Das erfolgreiche Team Inspector SlowMo, Detective ZeitRaffa und Agent Nicock kämpfen gegen" +
				" eine Terroristen Bande.\nIm Kampf wird Agent Nicock gefangen genommen von der Terroristen Bande" +
				" sie schließen sich in einem Haus ein. Inspector SlowMo jagt das Haus in die Luft." +
				" ZeitRaffa läuft dahin und sucht nach Nicock er findet ihn aber nicht.\n" +
				"Nach einer langen Suche beschließen die beiden zurück zufliegen als sie gerade abgehoben " +
				"kommt Nicock und sieht wie beide wegfliegen. Er schwört ewige Rachen an den beiden und an der ESS.\n" +
				"\n\n>------ Hauptstory ------<\n" +
				"1995 Transsilvanien(Rumänien)\nInspector SlowMo und Detective ZeitRaffa kommen in " +
				"Transsilvanien an es ist eine sehr ruhige Stadt es sind wenig Menschen auf der Straße.\n" +
				"Sie fahren zum letzten bekannten Aufenthaltsort von Agent Nicockn\n" +
				"Sie bleiben vor einer Burg stehen ZeitRaffa sagt:\"Es ist Hier\" beide gehen rein und werden von " +
				"ein paar Schlägern überwältigt." +
				"Als Inspector SlowMo und Detective ZeitRaffa zu sich kommen, sind ihre Mäntel " +
				"bereits mit einer schicht Staub bedeckt. ZeitRaffa sieht sich um während sich " +
				"SlowMo noch aufrappelt. \"Sind wir vergewaltigt worden?\" fragt SlowMo.\n" +
				"Der Raum, in dem sich die Helden befinden ist eine kleine verwinkelte Kammer, " +
				"in welche nur sehr wenig Licht fällt. \"Schwarzpulver\" murmelt ZeitRaffa nachdenklich...";
	}

}