package ita23.projekt.mud.events;

import ita23.projekt.mud.Game;

/**
 * Entwurfklasse um ein Event zu ersellen welches ausgelöst wird
 * und im Anschluss eine bestimmte Aktion ausführt.
 * @author Lukas Knuth
 *
 */
public abstract class BasicEvent {
	
	/**
	 * Gibt die aus zu gebende Nachricht dieses Events zurück
	 * @return Die Nachricht zu diesem Event
	 */
	public abstract String getEventMessage();
	
	/**
	 * Führt die Aktionen dieses Events aus.
	 */
	public abstract void doEvent();

	/**
	 * Das Game-Object des aktuellen Spiels (Zugriff auf Inventar)
	 */
	protected Game game;
	
	/**
	 * Konstruktor welcher eine Instanz des "Game"-Objekts
	 * für die Klasse und ihre Erweiterungen zur Verfügung
	 * stellt.
	 */
	public BasicEvent(){
		this.game = Game.getInstance();
	}
}
