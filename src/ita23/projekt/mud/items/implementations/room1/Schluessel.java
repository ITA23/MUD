package ita23.projekt.mud.items.implementations.room1;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.events.implementations.NextRoomEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;
import ita23.projekt.mud.items.implementations.special.Tuer;
import ita23.projekt.mud.rooms.implementations.WahrheitsRaum;

/**
 * Schlüssel welcher den weg zu Raum 2 öffnet
 * @author Lukas Knuth
 *
 */
public class Schluessel extends BasicItem{

	@Override
	public String getName() {
		return "Schluessel";
	}

	@Override
	public BasicEvent use(BasicItem item) throws CantUseItemException {
		if (item.getClass() == Tuer.class){
			String mess = "ZeitRaffa öffnet die Schwere Massivholztür mit dem Schlüssel.";
			return new NextRoomEvent(mess, new WahrheitsRaum());
		}
		throw new CantUseItemException(getName(), item.getName());
	}

}
