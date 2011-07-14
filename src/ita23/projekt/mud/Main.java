package ita23.projekt.mud;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Startpunkt des Programms, welcher das GUI erstellt und die Benutzer-
 * Eingaben entgegen nimmt.
 * @author Lukas Knuth
 *
 */
public class Main implements ActionListener{
	
	/** Instanz des Spiels */
	private Game game;
	/** Frame für die Konsole */
	private JFrame f;
	/** Eingabefeld für neue Befehle */
	private JTextField in;
	/** Zeigt ausgeben des Parsers an */
	private JTextArea out;
	/** Button zum absenden eines Befehls */
	private JButton send;
	
	/**
	 * Startet das Spiel und erstellt das GUI
	 */
	private Main(){
		game = Game.getInstance();
		// Mache GUI:
		makeGUI();
		// Zeige Epilog an:
		out.append(game.getStory()+"\n\n");
	}
	
	/**
	 * Erstellt das GUI und macht es sichtbar.
	 */
	public void makeGUI(){
		f = new JFrame("Inspector SlowMo und Detective ZeitRaffa");
		f.setLayout(new BorderLayout());
		// Box:
		out = new JTextArea(30, 80);
		out.setBackground(Color.BLACK);
		out.setFont(new Font("Monospaced", Font.PLAIN, 12));
		out.setForeground(Color.GREEN);
		out.setEditable(false);
		out.setLineWrap(true);
		out.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(out);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		f.add(scroll, BorderLayout.CENTER);
		// Senden:
		in = new JTextField(40);
		f.addWindowListener( new WindowAdapter() {
			public void windowOpened( WindowEvent e ){
				in.requestFocus();
			}
		}); 
		send = new JButton("do");
		send.addActionListener(this);
		f.getRootPane().setDefaultButton(send);
		JPanel p = new JPanel(new FlowLayout());
		p.add(in);
		p.add(send);
		f.add(p, BorderLayout.SOUTH);
		// Rest:
		f.pack();
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent w){
				System.exit(0);
			}
		});
		f.setVisible(true);
	}
	
	/**
	 * Sendet den eingegebenen String an den Parser.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		out.append( game.parse(in.getText())+"\n\n" );
		in.setText("");
		// Auto-Scroll:
		out.setCaretPosition(out.getText().length());
	}
	
	public static void main(String[] args){
		new Main();
	}

}
