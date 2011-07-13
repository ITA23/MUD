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
		return "Als Inspector SlowMo und Detective ZeitRaffa zu sich kommen, sind ihre Mäntel " +
				"bereits mit einer Sicht Staub bedeckt. ZeitRaffa sieht sich um während sich " +
				"SlowMo noch aufrappelt. \"Sind wir vergewaltigt worden?\" fragt SlowMo.\n" +
				"Der Raum, in dem sich die Helden befinden ist eine kleine verwinkelte Kammer, " +
				"in welche nur sehr wenig Licht fällt. \"Schwarzpulver\" murmelt ZeitRaffa nachdenklich...";
	}

}