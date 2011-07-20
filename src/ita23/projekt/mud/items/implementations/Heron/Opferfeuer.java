package ita23.projekt.mud.items.implementations.Heron;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.events.implementations.NextRoomEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;
import ita23.projekt.mud.rooms.implementations.Home;

/**
 *Wenn das Opferfeuer entz�ndet wurde, �ffnet sich die T�r
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

	@Override
	public String getInspectString() {
		return "Das Opferfeuer ist mit einem Behäler, der zu hälfte mit \n" +
				"Wasser gefüllt ist, verbunden. \n" +
				"Die Wärme des Feuers dehtn die Luft im Behälter und \n" +
				"drückt das Wasser in einen Eimer. \n" +
				"Der Eimmer wird immer schwerrer und öffnet über Seilzüge langsam die Tür. \n" +
				"Wenn das Feuer wieder erlischt kehrt sich der ganze Prosses um  \n" +
				"und die Tür schlisst sich wieder \n";
	}

	@Override
	public boolean isTakeable() {
		// TODO Auto-generated method stub
		return false;
	}

}
