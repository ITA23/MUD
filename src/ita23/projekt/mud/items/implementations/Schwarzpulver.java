package ita23.projekt.mud.items.implementations;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.events.implementations.ItemCombineEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;

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
