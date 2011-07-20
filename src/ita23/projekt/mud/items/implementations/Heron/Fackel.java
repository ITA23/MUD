package ita23.projekt.mud.items.implementations.Heron;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.events.implementations.NextRoomEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;
import ita23.projekt.mud.items.implementations.Heron.Opferfeuer;
import ita23.projekt.mud.rooms.implementations.Home;

/**
 *Mit der Fakel kann man das Opferfeuer entzünden
 * @author Fabian Bottler
 */

public class Fackel  extends BasicItem {

	@Override
	public String getName() {
		return "Fackel";
	}

	@Override
	public BasicEvent use(BasicItem item) throws CantUseItemException {
		if (Opferfeuer.class == item.getClass()){
			String msg = "Sie haben mit der Fackel das Opferfeuer entzündet.\n "+
			"Die Tür öffnet sich langsam mit lautem gequietsche...";
			return new NextRoomEvent(msg, new Home());
		}
		throw new CantUseItemException(getName(), item.getName());
		
	}

}
