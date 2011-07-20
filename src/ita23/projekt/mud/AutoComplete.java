package ita23.projekt.mud;

import java.util.ArrayList;

/**
 * Nimmt die Eingaben vom Benutzer und vervollständigt diese
 * @author Rafa Marques, Lukas Knuth
 * 
 */

public class AutoComplete {
	
	/** Array Liste für die Befehle */
	ArrayList<String> befehle = new ArrayList<String>();
	
	/** Alle Befehle */
	public AutoComplete() {
		befehle.add("benutze");
		befehle.add("inventar");
		befehle.add("hilfe");
		befehle.add("dinge");
		befehle.add("story");
		befehle.add("nimm");
		befehle.add("untersuchen");
	}
	
	/**
	 * Eingabe wird übergeben und geguckt ob es einen Befehl gibt
	 * @param eingabe vom Benutzer
	 * @return ergebnis oder null
	 */
	public String woerterChecken(String eingabe) {
		String ergebnis;
		int laenge = eingabe.length();
		
		for (String eintrag : befehle) {
			String teil = eintrag.toUpperCase();
			if (teil.startsWith(eingabe.toUpperCase())) {
				return eintrag;
			}
		}
		return null;
	}
	
}
