package ita23.projekt.mud;

import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.rooms.BasicRoom;
import ita23.projekt.mud.rooms.implementations.StartRoom;

import java.util.HashMap;
import java.util.Map;

public class Game {
	
	private static Game g;
	private Map<String, BasicRoom> rooms;
	private Map<String, BasicItem> inventar;
	/** Signalwörter für Aktionen */
	private static final String nehmen = "nimm ";
	
	public void parser(String input){
		if (input.startsWith(nehmen)){
			// Nimm irgendwas.
			
		}
	}
	
	
	
	/**
	 * Initialisiere das Spiel
	 */
	private void initialize(){
		rooms = new HashMap<String, BasicRoom>();
		rooms.put("start", new StartRoom());
		inventar = new HashMap<String, BasicItem>();
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
