package ita23.projekt.mud.items.implementations.home;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;

/**
 * Ein nutzloses Item, welches in Jimmys Zimmer
 *  herum liegt.
 * @author Lukas Knuth
 *
 */
public class AtomicToaster extends BasicItem{

	@Override
	public String getName() {
		return "Atomic Toaster";
	}

	@Override
	public String getInspectString() {
		return "Ein Toaster welcher Tanzt, wenn man ihm " +
				"Reaggea-Musik vorspielt.";
	}

	@Override
	public boolean isTakeable() {
		return false;
	}

	@Override
	public BasicEvent use(BasicItem item) throws CantUseItemException {
		throw new CantUseItemException("Dieses Item kann nicht " +
				"benutzt werden, weil es Sinnlos ist.");
	}

}
