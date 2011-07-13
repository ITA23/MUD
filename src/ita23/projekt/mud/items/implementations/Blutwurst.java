package ita23.projekt.mud.items.implementations;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.events.implementations.ItemCombineEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;
import ita23.projekt.mud.items.implementations.special.Selbst;

public class Blutwurst extends BasicItem{

	@Override
	public String getName() {
		return "Blutwurst";
	}

	@Override
	public BasicEvent use(BasicItem item) throws CantUseItemException {
		if (item.getClass() == Gummiente.class){
			throw new CantUseItemException("ZeitRafa war sich nicht sicher ob man die Ente fütter müsse...");
		} else if (item.getClass() == Selbst.class){
			String mess = "SlowMo beist in die Blutwurst. Hey, da ist ein Schlüssel drin!";
			return new ItemCombineEvent(this, item, new Schluessel(), mess);
		}
		throw new CantUseItemException("Kann "+item.getName()+" nicht mit "+this.getName()+" benutzen!");
	}

}
