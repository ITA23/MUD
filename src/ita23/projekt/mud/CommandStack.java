package ita23.projekt.mud;

import java.util.ArrayList;

/**
 * Sammelt die letzten vom Benutzer eingegebenen
 *  Befehle und kann sie wieder zurückgeben
 * @author Lukas Knuth, Rafa Marques
 *
 */
public class CommandStack {
	
	/** ArrayList welche die letzten Befehle sammelt */
	private ArrayList<String> stack;
	/** Aktuelle position in der Liste */
	private int position;
	
	/**
	 * Erstellt den Command-Stack, welcher die history
	 *  der eingegebenen befehle speichert.
	 */
	public CommandStack(){
		stack = new ArrayList<String>();
		stack.add("");
		position = 1;
	}
	
<<<<<<< HEAD
	// Wenn Pfeiltaste nach unten gedrückte
=======
	/**
	 * Gibt den (wenn möglich) nächsten eingegebenen
	 *  Befehl des Benutzers zurück.
	 * @return Das nächste Element in der Liste
	 */
>>>>>>> ea70a44348acf606ef2d4b51077519a189a098da
	public String getNext(){
		position++;
		if (position < 0){
			position = 0;
			return stack.get( 0 );
		} else if (position > (stack.size() - 1)) {
			position = (stack.size());
			return stack.get(0);
		}
		return stack.get(position);
	}
	
	/**
	 * Gibt den vorherigen Befehl des Benutzers
	 *  zurück
	 * @return Der vorherige Befehl in der Liste
	 */
	public String getPrevous(){
		position--;
		if (position < 1){
			position = 1;
			return stack.get( 1 );
		} 
		return stack.get(position);
	}
	
	/**
	 * Fügt einen neuen Befehl in die Liste
	 *  ein.
	 * @param s Der eingegebene Befehl als
	 *  String.
	 */
	public void add(String s){
		stack.add(s);
		position = stack.size();
	}

}
