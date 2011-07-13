package ita23.projekt.mud.items.implementations.special;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;

public class Selbst extends BasicItem{

	public Selbst(){
		super();
		this.setInInventar(true);
	}
	
	@Override
	public String getName() {
		return "Selbst";
	}

	@Override
	public BasicEvent use(BasicItem item) throws CantUseItemException {
		throw new CantUseItemException("Du kannst nur Dinge mit dir selbst benutzen.");
	}

}
