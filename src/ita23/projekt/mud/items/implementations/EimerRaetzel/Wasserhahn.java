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
public class Wasserhahn extends BasicItem{

	@Override
	public String getName() {
		return "Wasserhahan";
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
			return new EimerEventFabian(this,item,new Eimer3L_voll(), "Hallo");
		}else if (Eimer5Lleer.class == item.getClass()){
			return new EimerEventFabian(this,item,new Eimer5Lvoll(), "Hallo");
		}
		throw new CantUseItemException(getName(), item.getName());
	}

}
