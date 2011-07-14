package ita23.projekt.mud.items.implementations.room1;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.events.implementations.ItemCombineEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;

/**
 * Ein Seil, das sich in Raum 1 finden lässt.
 * @author Lukas Knuth
 *
 */
public class Seil extends BasicItem{

	@Override
	public String getName() {
		return "Seil";
	}

	@Override
	public BasicEvent use(BasicItem item) throws CantUseItemException {
		if (item.getClass() == Schwarzpulver.class){
			// Seil mit Schwarzpulver kombiniert:
			return new ItemCombineEvent(this, item, new Sprengsatz());
		}
		throw new CantUseItemException(getName(), item.getName());
	}

}
