package ita23.projekt.mud.items.implementations.room1;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.events.implementations.NextRoomEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;
import ita23.projekt.mud.items.implementations.special.Tuer;
import ita23.projekt.mud.rooms.implementations.WahrheitsRaum;

/**
 * Kann aus zwei Items in Raum 1 kombiniert werden.
 * @author Lukas Knuth
 *
 */
public class Sprengsatz extends BasicItem{

	@Override
	public String getName() {
		return "Sprengsatz";
	}

	@Override
	public BasicEvent use(BasicItem item) throws CantUseItemException {
		if (item.getClass() == Tuer.class){
			String mess = "SlowMo stoppt die Zeit damit die Bombe gefahrlos gezündet und die beiden sich vor " +
					"der Explusion in Sicherheit bringen können. Die Kraft der Explosion reist die Türe aus " +
					"den Angeln und öffnet den Weg in den nächsten Raum.";
			return new NextRoomEvent(mess, new WahrheitsRaum());
		}
		throw new CantUseItemException(getName(), item.getName());
	}

}
