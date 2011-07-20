package ita23.projekt.mud;

import java.util.ArrayList;

public class AutoComplete {
	
	ArrayList<String> befehle = new ArrayList<String>();
	
	public AutoComplete() {
		befehle.add("benutze");
		befehle.add("inventar");
		befehle.add("hilfe");
		befehle.add("dinge");
		befehle.add("story");
		befehle.add("nimm");
		befehle.add("untersuchen");
	}
	
	
	
	public String woerterChecken(String eingabe) {
		String ergebnis;
		int laenge = eingabe.length();
		
		for (String eintrag : befehle) {
			String teil = eintrag.substring(0, laenge);
			if (teil.equalsIgnoreCase(eingabe)) {
				return eintrag;
			}
		}
		return null;
	}
}
