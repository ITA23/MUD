package ita23.projekt.mud.items;

public class CantUseItemException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public CantUseItemException(String detailMessage, Throwable throwable){
		super(detailMessage, throwable);
	}
	
	public CantUseItemException(String detailMessage){
		super(detailMessage);
	}
	
	public CantUseItemException(String item1, String item2){
		super("Kann "+item1+" nicht mit "+item2+" benutzen.");
	}

}
