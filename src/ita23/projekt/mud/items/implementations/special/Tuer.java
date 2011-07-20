package ita23.projekt.mud.items.implementations.special;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;

/**
 * Item, welches die Türe zum nächsten Raum repräsentiert.
 *  Genau wie "Selbst" können gewisse Items mit der Tür
 *  kombiniert bzw. benutzt werden.
 * @author Lukas Knuth
 *
 */
public class Tuer extends BasicItem{

	@Override
	public String getName() {
		return "Tür";
	}

	@Override
	public BasicEvent use(BasicItem item) throws CantUseItemException {
		throw new CantUseItemException("Du Türe nicht benutzen");
	}

	@Override
	public String getInspectString() {
		return "Eine verschlossene Türe. Was sich wohl dahinter verbirgt...";
	}

	@Override
	public boolean isTakeable() {
		return false;
	}

}
