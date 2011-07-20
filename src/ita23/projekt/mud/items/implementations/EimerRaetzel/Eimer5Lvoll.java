package ita23.projekt.mud.items.implementations.EimerRaetzel;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.events.implementations.EimerEventFabian;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;

/**
 * Ein Teil des Unfertigen "Eimer-
 *  Rätsel"
 * @author Fabian Bottler
 *
 */
public class Eimer5Lvoll extends BasicItem{

	@Override
	public String getName() {
		return "Eimer5Lvoll";
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
		if (Eimer3Lleer.class == item.getClass()){
			return new EimerEventFabian(item,this, new Eimer5Lmit2L(), new Eimer3L_voll(), "Hallo");
		}
		throw new CantUseItemException(getName(), item.getName());
	}


}
