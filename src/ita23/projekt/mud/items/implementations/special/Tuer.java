package ita23.projekt.mud.items.implementations.special;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;

public class Tuer extends BasicItem{

	@Override
	public String getName() {
		return "Tuer";
	}

	@Override
	public BasicEvent use(BasicItem item) throws CantUseItemException {
		throw new CantUseItemException("Du Türe nicht benutzen");
	}

}
