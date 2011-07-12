package ita23.projekt.mud.events;

import ita23.projekt.mud.Game;

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
	
	public BasicEvent(){
		this.game = Game.getInstance();
	}
}
