package ita23.projekt.mud.items;

public abstract class BasicItem {
	
	private boolean inInventar = false;
	
	/**
	 * Gibt den Namen des Items zurück
	 * @return
	 */
	public abstract String getName();
	
	public boolean inInventar(){
		return inInventar;
	}
	
	public void setInInventar(boolean value){
		this.inInventar = value;
	}

}
