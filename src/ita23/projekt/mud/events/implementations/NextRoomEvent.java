package ita23.projekt.mud.events.implementations;

import ita23.projekt.mud.events.BasicEvent;
import ita23.projekt.mud.rooms.BasicRoom;

public class NextRoomEvent extends BasicEvent{
	
	private String message;
	private BasicRoom room;
	
	public NextRoomEvent(String message, BasicRoom room){
		this.message = message;
		this.room = room;
	}

	@Override
	public String getEventMessage() {
		return message + "\n\n" + room.getStory();
	}

	@Override
	public void doEvent() {
		game.setLevel(room);
	}

}
