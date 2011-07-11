package ita23.projekt.mud;

import ita23.projekt.mud.rooms.BasicRoom;
import ita23.projekt.mud.rooms.implementations.StartRoom;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	
	private Scanner in;
	
	private Main(){
		
		in = new Scanner(System.in);
		// Starte das Spiel:
		BasicRoom r = rooms.get("start");
		System.out.println(r.getStory());
		
	}
	
	public static void main(String[] args){
		new Main();
	}

}
