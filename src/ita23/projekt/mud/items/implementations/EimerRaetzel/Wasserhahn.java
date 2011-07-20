package ita23.projekt.mud.items.implementations.EimerRaetzel;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.events.implementations.EimerEventFabian;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;
import ita23.projekt.mud.items.implementations.Heron.Opferfeuer;
import ita23.projekt.mud.rooms.implementations.Home;

public class Wasserhahn extends BasicItem{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Wasserhahan";
	} 

	@Override
	public String getInspectString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTakeable() {
		// TODO Auto-generated method stub
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
