package ita23.projekt.mud;

import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.ItemNotFoundException;
import ita23.projekt.mud.rooms.BasicRoom;
import ita23.projekt.mud.rooms.implementations.StartRoom;

import java.util.HashMap;
import java.util.Map;

public class Game {
	
	private static Game g;
	private Map<String, BasicRoom> rooms;
	private Map<String, BasicItem> inventar;
	private boolean isPlaying;
	/** Aktueller Raum */
	private BasicRoom akt_room;
	/** Signalw�rter f�r Aktionen */
	private static final String NEHMEN = "nimm";
	private static final String DINGE = "dinge";
	private static final String LIST_INVENTAR = "inventar";
	private static final String HILFE = "hilfe";
	private static final String BEENDEN = "exit";
	
	/**
	 * Parst den input des Benutzers und gibt die Nachricht zur�ck.
	 * @param input Der eingabe-String des Benutzers
	 * @return Der generierte String.
	 */
	public String parse(String input){
		if (input.startsWith(DINGE)){
			// Liste alle Dinge im aktuellen Raum:
			return akt_room.listItems();
		} else if (input.startsWith(NEHMEN)){
			// Nimm irgendwas.
			String item_name = input.substring(NEHMEN.length()+1);
			try {
				BasicItem i = akt_room.getItem(item_name);
				inventar.put(item_name, i);
			} catch (ItemNotFoundException e) {
				return "In diesem Raum gibt es kein "+item_name;
			}
			return "Du hast "+item_name+" aufgenommen.";
		} else if (input.startsWith(LIST_INVENTAR)){
			// Liste alle Gegenst�nde im Inventar
			StringBuilder b = new StringBuilder();
			b.append("Dinge in deinem Inventar:\n");
			if (inventar.size() == 0) return "Dein Inventar ist leer";
			for ( Map.Entry<String, BasicItem> item : inventar.entrySet() ){
				b.append( "* "+item.getValue().getName()+"\n" );
			}
			return b.toString();
		} else if (input.startsWith(BEENDEN)){
			// Beende das Spiel
			this.isPlaying = false;
			return "Spiel wird beendet...";
		} else if (input.startsWith(HILFE)){
			// Ausgabe aller Befehle
			return DINGE+" <> Listet alle Dinge im aktuellen Raum auf\n" +
					NEHMEN+" <> Nimm einen Gegenstand aus dem aktuellen Raum\n" +
					LIST_INVENTAR+" <> Listet alle Gegenst�nde im Inventar auf\n" +
					BEENDEN+" <> Beendet das Spiel";
		} else {
			return input+" ist kein g�ltiger Befehl.";
		}
	}
	
	/**
	 * Gibt die Geschichte zum aktuellen Raum zur�ck.
	 * @return Die Geschichte als String
	 */
	public String getStory(){
		return akt_room.getStory();
	}
	
	/**
	 * Initialisiere das Spiel
	 */
	private void initialize(){
		rooms = new HashMap<String, BasicRoom>();
		rooms.put("start", new StartRoom());
		inventar = new HashMap<String, BasicItem>();
		// Setz den aktuellen Raum:
		akt_room = rooms.get("start");
		// Starte das Spiel:
		this.isPlaying = true;
	}
	
	/**
	 * Git "true" zur�ck wenn das Spiel noch l�uft.
	 * @return Ob das Spiel noch l�uft.
	 */
	public boolean isPlaying(){
		return isPlaying;
	}
	
	/**
	 * Privater Konstruktor damit nur eine Instanz erstellt werden kann.
	 */
	private Game(){
		this.initialize();
	}
	
	/**
	 * Gibt die einzige Instanz der Klasse zur�ck
	 * @return Die einzige Instanz der Klasse
	 */
	public static synchronized Game getInstance(){
		if (g == null){
			g = new Game();
		}
		return g;
	}

}
