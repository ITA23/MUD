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
	/** Signalwörter für Aktionen */
	private static final String NEHMEN = "nimm ";
	private static final String DINGE = "dinge";
	private static final String LIST_INVENTAR = "inventar";
	private static final String BEENDEN = "exit";
	
	/**
	 * Parst den input des Benutzers und gibt die Nachricht zurück.
	 * @param input Der eingabe-String des Benutzers
	 * @return Der generierte String.
	 */
	public String parse(String input){
		if (input.startsWith(DINGE)){
			// Liste alle Dinge im aktuellen Raum:
			return akt_room.listItems();
		} else if (input.startsWith(NEHMEN)){
			// Nimm irgendwas.
			String item_name = input.split(" ")[1];
			try {
				BasicItem i = akt_room.getItem(item_name);
				i.setHidden(false);
				inventar.put(item_name, i);
			} catch (ItemNotFoundException e) {
				return "In diesem Raum gibt es kein "+item_name;
			}
			return "Du hast "+item_name+" aufgenommen.";
		} else if (input.startsWith(LIST_INVENTAR)){
			// Liste alle Gegenstände im Inventar
			StringBuilder b = new StringBuilder();
			for ( Map.Entry<String, BasicItem> item : inventar.entrySet() ){
				if (!item.getValue().isHidden()){
					b.append( item.getValue().getName() );
				}
			}
			return b.toString();
		} else if (input.startsWith(BEENDEN)){
			this.isPlaying = false;
			return "Spiel wird beendet...";
		} else {
			return input+" ist kein gültiger Befehl.";
		}
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
	 * Git "true" zurück wenn das Spiel noch läuft.
	 * @return Ob das Spiel noch läuft.
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
	 * Gibt die einzige Instanz der Klasse zurück
	 * @return Die einzige Instanz der Klasse
	 */
	public static synchronized Game getInstance(){
		if (g == null){
			g = new Game();
		}
		return g;
	}

}
