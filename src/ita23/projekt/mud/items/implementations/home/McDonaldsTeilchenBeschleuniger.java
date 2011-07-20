package ita23.projekt.mud.items.implementations.home;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;

/**
 * Ein Sinnloses Item welches in Jimmys Zimmer herum
 *  liegt.
 * @author Lukas Knuth
 *
 */
public class McDonaldsTeilchenBeschleuniger extends BasicItem{

	@Override
	public String getName() {
		return "McDonalds Teilchen Beschleuniger";
	}

	@Override
	public BasicEvent use(BasicItem item) throws CantUseItemException {
		throw new CantUseItemException("Dieses Item kann nicht benutzt werden, weil es" +
				" Sinnlos ist.");
	}

	@Override
	public String getInspectString() {
		return "Ein Sinnloses Spielzeug aus dem Happy Meal.";
	}

	@Override
	public boolean isTakeable() {
		return false;
	}

}
