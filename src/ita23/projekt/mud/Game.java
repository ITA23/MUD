package ita23.projekt.mud;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.CantUseItemException;
import ita23.projekt.mud.items.ItemNotFoundException;
import ita23.projekt.mud.items.implementations.special.Selbst;
import ita23.projekt.mud.items.implementations.special.Tuer;
import ita23.projekt.mud.items.implementations.tutorial.MP40;
import ita23.projekt.mud.rooms.BasicRoom;
import ita23.projekt.mud.rooms.implementations.Tutorial;

import java.util.HashMap;
import java.util.Map;

/**
 * Parst die Eingabe des Benutzers und verwaltet das Spiel
 * (Inventar, Befehle, etz).
 * @author Lukas Knuth
 *
 */
public class Game {
	
	/** Instanz der eigenen Klasse (Singleton) */
	private static Game g;
	/** Das Inventar des Spielers */
	public Map<String, BasicItem> inventar;
	/** Aktueller Raum */
	private BasicRoom akt_room;
	/** Bestimmt, ob das Spiel im Tutorial-Modus ist */
	private boolean isTutorial;
	
	/** Befehl zum Nehemen eines Gegenstandes */
	private static final String NEHMEN = "nimm";
	/** Befehl zum auflisten aller Dinge im aktuellen Raum */
	private static final String DINGE = "dinge";
	/** Befehl zum auflisten aller Gegenstände im eigenen Inventar */
	private static final String LIST_INVENTAR = "inventar";
	/** Befehl zum benutzt zwei Gegenstände miteinander */
	private static final String BENUTZE = "benutze";
	/** Befehl um die Story zum aktuellen Raum erneut aus zu geben */
	private static final String STORY = "story";
	/** Befehl zum anzeigen aller Befehle und ihrer Wirkung */
	private static final String HILFE = "hilfe";
	
	/** Signalwort für die Benutzung eines Items mit dem Spieler selbst */
	private static final String SELBST = "selbst";
	/** Signalwort für die Benutzung eines Gegenstandes mit der Tür zum 
	 * nächsten Raum.
	 */
	private static final String TUER = "tür";
	
	
	/**
	 * Parst den input des Benutzers und gibt die Nachricht zurück.
	 * @param input Der eingabe-String des Benutzers
	 * @return Der generierte String.
	 */
	public String parse(String input){
		if (input.startsWith(DINGE)){
			// Liste alle Dinge im aktuellen Raum:
			String ret = akt_room.listItems();
			if (isTutorial){
				ret += "\n"+
				"> \"Sehr gut, der Private davorn hat noch eins. Nehmen sie es, er braucht es nicht mehr!\"\n\n "+
				"  Um einen Gegenstand benutzen zu können nehmen Sie ihn auf um ihn in Ihr Inventar zu packen. " +
				"Benutzen Sie dazu den \"nimm\"-Befehl mit dem Namen des Items: " +
				"\"Nimm Magazin\" Die Groß- und Kleinschreibung spielt hierbei keine Rolle.";
			}
			return ret;
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
			// Gib Nachricht zurück
			String msg = "Du hast "+item_name+" aufgenommen.";
			if (isTutorial){
				msg += "\n\n> \"Glotzen sie es nicht an, laden sie nach!\" \n\n"+
				"  Sie könne das \"Magazin\" aus ihrem Inventar mit ihrer \"MP40\" benutzen. \n" +
				"Nutzen Sie dazu den \"benutze\"-Befehl: \"benutze Magazin mit MP40\""; 
			}
			return msg;
		} 
		// ------------------------------------
		else if (input.startsWith(LIST_INVENTAR)){
			// Liste alle Gegenstände im Inventar
			StringBuilder b = new StringBuilder();
			b.append("Dinge in deinem Inventar:\n\n");
			if (inventar.size() == 0) return "Dein Inventar ist leer";
			for ( Map.Entry<String, BasicItem> item : inventar.entrySet() ){
				b.append( "\t* "+item.getValue().getName() );
			}
			// Gib Ergebniss zurück
			String msg = b.toString()+"\n";
			if (isTutorial){
				msg += "\n\n> \"Verdammt, ich hab auch keins mehr. " +
						"Vielleicht liegt eins hier rum, schauen sie mal nach!\" \n\n"+
						" Um Dinge welche sie nehmen könne in ihrer Umgebung zu finden, " +
						"benutzen Sie den \"dinge\"-Befehl";
			}
			return msg;
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
		else if (input.startsWith(STORY)){
			// Story nochmla lesen:
			return akt_room.getStory();
		}
		// ------------------------------------
		else if (input.startsWith(HILFE)){
			// Ausgabe aller Befehle
			String msg = DINGE+" \t\t Listet alle Dinge im aktuellen Raum auf\n" +
					NEHMEN+" \t\t Nimm einen Gegenstand aus dem aktuellen Raum\n" +
					LIST_INVENTAR+" \t Listet alle Gegenstände im Inventar auf\n" +
					BENUTZE+" [Item] mit [Item] \t Benute einen Gegenstand im Inventar mit einem anderen. Gegnstände können auch mit \"tür\" und \"selbst\" benuzt werden.\n"+
					STORY+" \t\t Zeigt die Story zum aktuellen Raum erneut an.\n";
			if (isTutorial){
				msg += "\n> \"Private! Soldat! Kommen sie zu sich, wir haben eine Mission zu erfüllen!\" \n" +
				"> \"Ja... Jawohl Sir!\" \n"+
				"> \"Beruhigen sie sich, es ist noch alles dran, sie können weiter kämpfen. " +
						"Ihre MP40 ist leer geschossen, sehen sie mal nach ob sie noch ein Magazin haben!\" \n" +
				"\nUm eine Liste aller Dinge die Sie an sich tragen zu sehen, kann der Befehl \"inventar\" verwendet werden.";
			}
			return msg;
		} 
		// ------------------------------------
		else {
			return input+" ist kein gültiger Befehl. Benutze \""+HILFE+"\" für eine Auflistung aller Befehle.";
		}
	}
	
	/**
	 * Seztz den Modus des Spiels auf normal und verlässt
	 * das Tutorial.
	 */
	public void leaveTutorial(){
		this.isTutorial = false;
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
		isTutorial = true;
		// Setz den aktuellen Raum:
		akt_room = new Tutorial();
		inventar.put(new MP40().getName().toUpperCase(), new MP40());
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
