package ita23.projekt.mud.items;

public abstract class BasicItem {
	
	private boolean isHidden = false;
	
	/**
	 * Gibt den Namen des Items zurück
	 * @return
	 */
	public abstract String getName();
	
	public boolean isHidden(){
		return isHidden;
	}
	
	public void setHidden(boolean value){
		this.isHidden = value;
	}

}
