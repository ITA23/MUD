package ita23.projekt.mud.rooms.implementations;

import ita23.projekt.mud.rooms.BasicRoom;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.implementations.EimerRaetzel.*;

/**
 * Das Rätsel mit dem 5L und 3L Eimer. 
 * Wie erhlte ich genau 4L.
 * @author Fabian Bottler
 *
 */
public class EimerRätsel extends BasicRoom{

	@Override
	public void initialisieren() {
		this.dinge = new BasicItem[3];
		dinge[0] = new Eimer3Lleer();
		dinge[1] = new Eimer5Lleer();
		dinge[2] = new Wasserhahn();
	}

	@Override
	public String getStory() {
		return "Das Eimer Rätsel";
	}
	
}
