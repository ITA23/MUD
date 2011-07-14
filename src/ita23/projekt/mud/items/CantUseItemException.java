package ita23.projekt.mud.items;

/**
 * Exception welche ausgelöst wird, wenn zwei Items
 *  nicht miteinander benutzt werden können.
 * @author Lukas Knuth
 *
 */
public class CantUseItemException extends Exception{
	
	/** Standart serialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * Erstellt eine neue Exception mit der übergebenen
	 *  Nachricht.
	 * @param detailMessage Die Nachricht, welche von der
	 *  Exception zurück gegeben wird.
	 */
	public CantUseItemException(String detailMessage){
		super(detailMessage);
	}
	
	/**
	 * Erstellt eine neue Exception mit einer Standart-
	 *  Nachricht.
	 * @param item1 Name des ersten Items
	 * @param item2 Name des zweiten Items
	 */
	public CantUseItemException(String item1, String item2){
		super("Kann "+item1+" nicht mit "+item2+" benutzen.");
	}

}
