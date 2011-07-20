package ita23.projekt.mud.items.implementations.EimerRaetzel;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;

/**
 * Ein Teil des Unfertigen "Eimer-
 *  Rätsel"
 * @author Fabian Bottler
 *
 */
public class Eimer3L_voll extends BasicItem{

	@Override
	public String getName() {
		return "Eimer3Lvoll";
	}

	@Override
	public String getInspectString() {
		return null;
	}

	@Override
	public boolean isTakeable() {
		return true;
	}

	@Override
	public BasicEvent use(BasicItem item) throws CantUseItemException {
		return null;
	}

}
