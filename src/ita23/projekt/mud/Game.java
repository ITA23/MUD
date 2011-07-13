package ita23.projekt.mud;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;
import ita23.projekt.mud.items.ItemNotFoundException;
import ita23.projekt.mud.items.implementations.special.Selbst;
import ita23.projekt.mud.items.implementations.special.Tuer;
import ita23.projekt.mud.rooms.BasicRoom;
import ita23.projekt.mud.rooms.implementations.StartRoom;

import java.util.HashMap;
import java.util.Map;

public class Game {
	
	private static Game g;
	public Map<String, BasicItem> inventar;
	private boolean isPlaying;
	/** Aktueller Raum */
	private BasicRoom akt_room;
	/** Signalwörter für Aktionen */
	private static final String NEHMEN = "nimm";
	private static final String DINGE = "dinge";
	private static final String LIST_INVENTAR = "inventar";
	private static final String BENUTZE = "benutze";
	private static final String STORY = "story";
	private static final String HILFE = "hilfe";
	private static final String BEENDEN = "exit";
	private static final String SELBST = "selbst";
	private static final String TUER = "tuer";
	
	/**
	 * Parst den input des Benutzers und gibt die Nachricht zurück.
	 * @param input Der eingabe-String des Benutzers
	 * @return Der generierte String.
	 */
	public String parse(String input){
		if (input.startsWith(DINGE)){
			// Liste alle Dinge im aktuellen Raum:
			return akt_room.listItems();
		} 
		// ------------------------------------
		else if (input.startsWith(NEHMEN)){
			// Checken ob der Befehl richtig eingegeben wurde:
			if (input.length() <= NEHMEN.length() +1){
				return "Die Syntax lautet: \"nimm [item]\"";
			}
			// Nimm irgendwas.
			String item_name = input.substring(NEHMEN.length()+1);
			try {
				BasicItem i = akt_room.getItem(item_name);
				inventar.put(i.getName().toUpperCase(), i);
			} catch (ItemNotFoundException e) {
				return "In diesem Raum gibt es kein "+item_name;
			}
			return "Du hast "+item_name+" aufgenommen.";
		} 
		// ------------------------------------
		else if (input.startsWith(LIST_INVENTAR)){
			// Liste alle Gegenstände im Inventar
			StringBuilder b = new StringBuilder();
			b.append("Dinge in deinem Inventar:\n");
			if (inventar.size() == 0) return "Dein Inventar ist leer";
			for ( Map.Entry<String, BasicItem> item : inventar.entrySet() ){
				b.append( "\n* "+item.getValue().getName() );
			}
			return b.toString();
		} 
		// ------------------------------------
		else if (input.startsWith(BENUTZE)){
			// Benutze einen Gegenstand aus dem Inventar
			String[] befehl = input.split(" ");
			// Teste ob valider befehl:
			if (befehl.length != 4){
				return "Die Syntax lautet: \"benutze [item] mit [item]\"";
			}
			if (inventar.containsKey(befehl[1].toUpperCase()) ){
				// Check ob selbst/tür oder item:
				BasicItem tmp = null;
				if ( inventar.containsKey(befehl[3].toUpperCase()) ){
					tmp = inventar.get(befehl[3].toUpperCase());
				} else if ( befehl[3].equalsIgnoreCase(SELBST) ){
					tmp = new Selbst();
				} else if ( befehl[3].equalsIgnoreCase(TUER) ){
					tmp = new Tuer();
				} else {
					return "In deinem Inventar befindet sich kein "+befehl[1]+ "/"+befehl[3];
				}
				try {
					BasicEvent e = inventar.get( befehl[1].toUpperCase() ).use( tmp );
					// Führe Event-Aktionen durch:
					e.doEvent();
					return e.getEventMessage();
				} catch (CantUseItemException e) {
					return e.getMessage();
				}
			} else {
				return "In deinem Inventar befindet sich kein "+befehl[1]+ "/"+befehl[3];
			}
		} 
		// ------------------------------------
		else if (input.startsWith(BEENDEN)){
			// Beende das Spiel
			this.isPlaying = false;
			return "Spiel wird beendet...";
		} 
		// ------------------------------------
		else if (input.startsWith(STORY)){
			// Story nochmla lesen:
			return akt_room.getStory();
		}
		// ------------------------------------
		else if (input.startsWith(HILFE)){
			// Ausgabe aller Befehle
			return DINGE+" \t\t Listet alle Dinge im aktuellen Raum auf\n" +
					NEHMEN+" \t\t Nimm einen Gegenstand aus dem aktuellen Raum\n" +
					LIST_INVENTAR+" \t Listet alle Gegenstände im Inventar auf\n" +
					BENUTZE+" [Item] mit [Item] \t Benute einen Gegenstand im Inventar mit einem anderen. Gegnstände können auch mit \"Tür\" und \"Selbst\" benuzt werden.\n"+
					STORY+" \t\t Zeigt die Story zum aktuellen Raum erneut an.\n"+
					BEENDEN+" \t\t Beendet das Spiel";
		} 
		// ------------------------------------
		else {
			return input+" ist kein gültiger Befehl. Benutze \""+HILFE+"\" für eine Auflistung aller Befehle.";
		}
	}
	
	/**
	 * Setzt das aktuelle Level des Spiels
	 * @param level
	 */
	public void setLevel(BasicRoom level){
		this.akt_room = level;
	}
	
	/**
	 * Gibt die Geschichte zum aktuellen Raum zurück.
	 * @return Die Geschichte als String
	 */
	public String getStory(){
		return akt_room.getStory();
	}
	
	/**
	 * Initialisiere das Spiel
	 */
	private void initialize(){
		inventar = new HashMap<String, BasicItem>();
		// Setz den aktuellen Raum:
		akt_room = new StartRoom();
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
