package ita23.projekt.mud.items.implementations.Heron;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.events.implementations.NextRoomEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;
import ita23.projekt.mud.rooms.implementations.Abspann;

/**
 *Wenn das Opferfeuer entzündet wurde, öffnet sich die Tür
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
		if (Fackel.class == item.getClass()){
			String msg = "Sie haben mit der Fackel das Opferfeuer entzündet.\n "+
			"Die Tür öffnet sich langsam mit lautem gequietsche...";
			return new NextRoomEvent(msg, new Abspann());
		}
		throw new CantUseItemException(getName(), item.getName());
		
	}

	@Override
	public String getInspectString() {
		return 	"Das Opferfeuer ist mit einem Behälter, der zu Hälfte mit \n" +
				"Wasser gefüllt ist, verbunden. \n" +
				"Die Wärme des Feuers dehnt die Luft im Behälter und \n" +
				"drückt das Wasser in einen Eimer. \n" +
				"Der Eimer wird immer schwerer und öffnet über Seilzüge langsam die Tür. \n" +
				"Wenn das Feuer wieder erlischt kehrt sich der ganze Prozess um  \n" +
				"und die Tür schlisst sich wieder \n";
	}

	@Override
	public boolean isTakeable() {
		return false;
	}

}
