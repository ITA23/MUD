package ita23.projekt.mud;

import java.util.ArrayList;

/**
 * Sammelt die letzten vom Benutzer eingegebenen
 *  Befehle und kann sie wieder zurückgeben
 * @author Lukas Knuth, Rafa Marques
 *
 */
public class CommandStack {
	
	private ArrayList<String> stack;
	private int position;
	
	public CommandStack(){
		stack = new ArrayList<String>();
		stack.add("");
		position = 1;
	}
	
	// Wenn Pfeiltaste nach unten gedrückte
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
	
	// Wenn Pfeiltaste nach oben gedrückt
	public String getPrevous(){
		position--;
		if (position < 1){
			position = 1;
			return stack.get( 1 );
		} 
		return stack.get(position);
	}
	
	public void add(String s){
		stack.add(s);
		position = stack.size();
	}

}
