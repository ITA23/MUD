package ita23.projekt.mud;

import java.util.Scanner;

public class Main {
	
	private Scanner in;
	private Game game;
	
	private Main(){
		in = new Scanner(System.in);
		game = Game.getInstance();
		// Prolog:
		pl("\n\nInspector SlowMo und Detective ZeitRaffa - Nico's Rache\n" +
			"--------------");
		// Starte das Spiel:
		loop();
	}
	
	/**
	 * Nimmt eingaben entgegen und reagiert darauf.
	 */
	private void loop(){
		pl(game.getStory());
		while (game.isPlaying()){
			input();
			pl(game.parse(in.nextLine()));
		} 
	}
	
	private void pl(String in){
		System.out.println(in);
	}
	
	private void input(){
		System.out.print("> ");
	}
	
	public static void main(String[] args){
		new Main();
	}

}
