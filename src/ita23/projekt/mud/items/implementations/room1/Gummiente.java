package ita23.projekt.mud.items.implementations.room1;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;

/**
 * Eine Gummiente aus dem ersten Raum.
 * @author Lukas Knuth
 *
 */
public class Gummiente extends BasicItem{

	@Override
	public String getName() {
		return "Gummiente";
	}

	@Override
	public BasicEvent use(BasicItem item) throws CantUseItemException {
		throw new CantUseItemException(getName(), item.getName());
	}

}
