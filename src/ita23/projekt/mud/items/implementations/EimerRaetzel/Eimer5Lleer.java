package ita23.projekt.mud.items.implementations.EimerRaetzel;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.events.implementations.EimerEventFabian;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;

public class Eimer5Lleer  extends BasicItem {

	@Override
	public String getName() {
		return "Leerer 5L Eimer";
	}

	@Override
	public String getInspectString() {
		return "asd";
	}

	@Override
	public boolean isTakeable() {
		return true;
	}

	@Override
	public BasicEvent use(BasicItem item) throws CantUseItemException {
		if (Wasserhahn.class == item.getClass()){
			String msg = "Sie haben mit der Fackel das Opferfeuer entz�ndet.\n "+
			"Die T�r �ffnet sich langsam mit lautem gequietsche...";
			return new EimerEventFabian(item,this, new Eimer5Lvoll(), "Hallo");
		}
		throw new CantUseItemException(getName(), item.getName());
	}

}
