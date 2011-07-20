package ita23.projekt.mud.items.implementations.home;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.events.implementations.NextRoomEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;
import ita23.projekt.mud.items.implementations.special.Selbst;
import ita23.projekt.mud.rooms.implementations.Heron;

/**
 * Türklinke in Jonnys Zimmer welches das
 *  erste Rätsel aufruft.
 * @author Lukas Knuth
 *
 */
public class Klinke extends BasicItem{

	@Override
	public String getName() {
		return "Türklinke";
	}

	@Override
	public String getInspectString() {
		return "Der weg ins Abenteuer ist nur ein \"benutze "+
			getName()+" mit selbst\" entfernt!";
	}

	@Override
	public boolean isTakeable() {
		return false;
	}

	@Override
	public BasicEvent use(BasicItem item) throws CantUseItemException {
		if (Selbst.class == item.getClass()){
			// Öffne die Türe
			return new NextRoomEvent("Auf in's Abenteuer!\n-----------", new Heron());
		}
		throw new CantUseItemException(this.getName(), item.getName());
	}

}
