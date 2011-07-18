package ita23.projekt.mud.rooms;

import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.items.ItemNotFoundException;

/**
 * Entwurfsmuster für einen Raum der im Spiel ein
 *  Level repräsentiert.
 * @author Lukas Knuth
 *
 */
public abstract class BasicRoom {
	
	/**
	 * Konstruktor, welcher die "initialisieren()"-
	 *  methode der Klasse aufruft.
	 */
	public BasicRoom(){
		this.initialisieren();
	}
	
	/**
	 * Items, die in diesem Raum gefuden werden können.
	 */
	protected BasicItem[] dinge;
	
	/**
	 * Macht die Grundarbeit damit der Raum gespielt
	 *  werden kann, wie z.B. das hinzufügen der Items
	 *  zum "dinge"-Array.
	 */
	public abstract void initialisieren();
	
	/**
	 * Gibt die Story zu diesem Raum als String zurück.
	 * @return
	 */
	public abstract String getStory();
	
	/**
	 * Gibt ein Item zurück, welches sich in diesem Raum befindet.
	 * @param name Der Name des Items.
	 * @return Das genannte Item
	 * @throws ItemNotFoundException Wird geworfen, wenn das
	 *  angegebene Item in diesem Raum nicht gefunden wurde.
	 */
	public BasicItem getItem(String name) throws ItemNotFoundException{
		for (BasicItem item : dinge){
			if (item.getName().equalsIgnoreCase(name)){
				item.setInInventar(true);
				return item;
			}
		}
		throw new ItemNotFoundException("Das Item konnte nicht gefunden werden");
	}
	
	/**
	 * Gibt eine Liste der Items in diesem Raum zurück.
	 * @return Die Liste der Items in diesem Raum
	 */
	public String listItems(){
		StringBuilder b = new StringBuilder();
		String nachricht = "Gegenstände in diesem Raum:\n\n";
		for (BasicItem item : dinge){
			if (!item.inInventar()) b.append("\t* "+item.getName());
		}
		if (b.length() == nachricht.length()) return "Es befinden sich keine Gegenstände in diesem Raum";
		return nachricht + b.toString() + "\n";
	}

}
