package ita23.projekt.mud.items.implementations.room1;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.events.implementations.ItemCombineEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;

/**
 * Schwarzpulver, welches in Raum 1 gefunden werden kann.
 * @author Lukas Knuth
 *
 */
public class Schwarzpulver extends BasicItem{

	@Override
	public String getName() {
		return "Schwarzpulver";
	}

	@Override
	public BasicEvent use(BasicItem item) throws CantUseItemException {
		if (item.getClass() == Seil.class){
			// Wenn Schwarzpulver mit Seil kombiniert:
			return new ItemCombineEvent(this, item, new Sprengsatz());
		}
		throw new CantUseItemException(getName(), item.getName());
	}

}
