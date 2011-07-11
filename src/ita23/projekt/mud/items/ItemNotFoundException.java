package ita23.projekt.mud.items;

public class ItemNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ItemNotFoundException(String detailMessage, Throwable throwable){
		super(detailMessage, throwable);
	}
	
	public ItemNotFoundException(String detailMessage){
		super(detailMessage);
	}

}
