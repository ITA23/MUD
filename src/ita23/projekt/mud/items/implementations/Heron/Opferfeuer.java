package ita23.projekt.mud.items.implementations.Heron;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.events.implementations.NextRoomEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;
import ita23.projekt.mud.rooms.implementations.Home;

/**
 *Wenn das Opferfeuer entz�ndet wurd, �ffnet sich die T�r
 * @author Fabian Bottler
 *
 */

public class Opferfeuer extends BasicItem {

	@Override
	public String getName() {
		return "Opferfeuer";
	}

	@Override
	public BasicEvent use(BasicItem item) throws CantUseItemException {
		if (Opferfeuer.class == item.getClass()){
			String msg = "Sie haben mit der Fackel das Opferfeuer entz�ndet.\n "+
			"Die T�r �ffnet sich langsam mit lautem gequietsche...";
			return new NextRoomEvent(msg, new Home());
		}
		throw new CantUseItemException(getName(), item.getName());
		
	}

}
