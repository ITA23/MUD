package ita23.projekt.mud;

import java.util.ArrayList;

/**
 * Nimmt die Eingaben vom Benutzer entgegen und
 *  versucht aus allen verfügbaren Befehlen den
 *  richtigen vor zu schlagen.
 * @author Rafa Marques, Lukas Knuth
 * 
 */

public class AutoComplete {
	
	/** Array Liste für die Befehle */
	ArrayList<String> befehle = new ArrayList<String>();
	
	/**
	 * Befüllt die ArrayList mit allen möglichen
	 *  Befehlen.
	 */
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
	 * @param eingabe Eingabe vom Benutzer
	 * @return ergebnis Den Befehl als String oder null
	 */
	public String woerterChecken(String eingabe) {
		for (String eintrag : befehle) {
			String teil = eintrag.toUpperCase();
			if (teil.startsWith(eingabe.toUpperCase())) {
				return eintrag;
			}
		}
		return null;
	}
	
}
