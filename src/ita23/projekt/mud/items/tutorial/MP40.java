package ita23.projekt.mud.items.tutorial;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.events.implementations.NextRoomEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;
import ita23.projekt.mud.rooms.implementations.Home;

/**
 * MP40 welche im Tutorial verwendet wird.
 * @author ita23
 *
 */
public class MP40 extends BasicItem{
	
	/**
	 * Setzt die MP40 automatisch in das Inventar
	 *  des Spielers.
	 */
	public MP40(){
		super();
		this.inInventar();
	}

	@Override
	public String getName() {
		return "MP40";
	}

	@Override
	public BasicEvent use(BasicItem item) throws CantUseItemException {
		if (MP40.class == item.getClass()){
			String msg = ">  \"Sehr gut. Sie sind ein echter Soldat Private Weichei! " +
					"Und jetzt knallen sie ein paar Feinde a...\"\n" +
					"*piieeeep*";
			return new NextRoomEvent(msg, new Home());
		}
		throw new CantUseItemException(getName(), item.getName());
	}

}
