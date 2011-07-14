package ita23.projekt.mud;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {
	
	private Scanner in;
	private Game game;
	private PrintStream ps;
	
	private Main(){
		in = new Scanner(System.in);
		game = Game.getInstance();
		try {
			ps = new PrintStream(System.out, true, "UTF-8");
		} catch (UnsupportedEncodingException e) {}
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
		ps.println(in);
	}
	
	private void input(){
		System.out.print("\n> ");
	}
	
	public static void main(String[] args){
		new Main();
	}

}
