package ita23.projekt.mud.items.implementations.tutorial;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.events.implementations.NextRoomEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;
import ita23.projekt.mud.rooms.implementations.Home;

/**
 * Ein Magazin welches benutzt werden kann, um
 *  die MP40 nach zu laden.
 * @author Lukas Knuth
 *
 */
public class Magazin extends BasicItem{

	@Override
	public String getName() {
		return "Magazin";
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
