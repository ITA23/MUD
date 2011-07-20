package ita23.projekt.mud.items.implementations.EimerRaetzel;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.events.implementations.EimerEventFabian;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;

public class Eimer3Lleer extends BasicItem {

	@Override
	public String getName() {
		return "Leerer 3L Eimer";
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
			return new EimerEventFabian(new Wasserhahn(),new Eimer3Lleer(),new Eimer3L_voll(), "Hallo");
		}
		throw new CantUseItemException(getName(), item.getName());
	}
}
