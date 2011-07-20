package ita23.projekt.mud.items;

/**
 * Wird geschmissen wenn ein Item welches nicht aufgenommen
 *  werden kann aufgenommen werden sollte.
 * @author Lukas Knuth
 *
 */
public class CantTakeItemException extends Exception{

	/** Standart serialVersion */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Erstellt die Exception mit der Nachricht welche
	 *  das Problem beschreibt.
	 * @param detailMessage Die beschreibung des Problems.
	 */
	public CantTakeItemException(String detailMessage){
		super(detailMessage);
	}

}
