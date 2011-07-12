package ita23.projekt.mud.items.implementations;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;

public class Sprengsatz extends BasicItem{

	@Override
	public String getName() {
		return "Sprengsatz";
	}

	@Override
	public BasicEvent use(BasicItem item) throws CantUseItemException {
		throw new CantUseItemException("Geht novh nicht");
	}

}
