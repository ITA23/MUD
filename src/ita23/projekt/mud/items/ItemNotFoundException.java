package ita23.projekt.mud.items;

/**
 * Exception welche ausgelöst wird, wenn der Spieler versucht
 *  ein Item auf zu nehemen, welches im aktuellen Raum nicht
 *  existiert.
 * @author Lukas Knuth
 *
 */
public class ItemNotFoundException extends Exception{
	
	/** Standart serialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * Erstellt die Exception mit der übergebenen Nachricht
	 * @param detailMessage Die Nachricht, welche von der
	 *  Exception zurück gegeben wird.
	 */
	public ItemNotFoundException(String detailMessage){
		super(detailMessage);
	}

}
