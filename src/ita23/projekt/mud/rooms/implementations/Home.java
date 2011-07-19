package ita23.projekt.mud.rooms.implementations;

import ita23.projekt.mud.items.BasicItem;
import ita23.projekt.mud.rooms.BasicRoom;

/**
 * Raum, welcher Jimmys Zimmer Repräsentiert.
 * @author Lukas Knuth
 *
 */
public class Home extends BasicRoom{

	@Override
	public void initialisieren() {
		this.dinge = new BasicItem[0];
	}

	@Override
	public String getStory() {
		return "> \"Was für ein scheiß Spiel...\"\n\n" +
				"Jimmy Pressgo wirft den Kontroller seiner Konsole hinter sich auf das Sofa und gähnte " +
				"laut vor sich hin. Der aufgewirbelte Staub stieg ihm in die Nase und er niest laut. " +
				"Der Raum ist abgedunkelt, das einzige Licht scheint durch einen Spalt in der Rollade. " +
				"Ein einsamer Lichtstrahl bricht sich im Staub und zieht eine kleine Brücke durch den Raum." +
				"\n" +
				"Seit Wochen hatte Jimmy keinen neuen Fall mehr bekommen. Seine letzte großer Fall war die " +
				"verschwundene Taschenuhr von Mr. Helber. Er hatte Langeweile und es war niemand da der sich " +
				"für ihn interessierte. Seid sein Vater im Krieg gefallen war arbeitete seine Mutter den ganzen " +
				"Tag, Geschwister hatte er keine. In der Schule war er nicht der beliebteste, war er doch in " +
				"fast allen Fächer Klassenbester." +
				"\n" +
				"Sein einziger echter Freund war Woody. Mit Woody konnte er reden wenn er Kummer hatte. " +
				"Woody hörte zu und wusste fast immer Rat." +
				"\n\n" +
				"> \"Jimmy, es gibt Essen!\" \n"+
				"> \"Ja Mom!\" \n"+
				"> \"Jimmy es ist ein Brief für dich gekommen. Von einem Mr. Helber?\"" +
				"\n\n" +
				"Aufgeregt riss er den Briefumschlag auf, entfaltete das Papier und las, was dort gedruckt stand." +
				"\n\n" +
				"> \"Er... Er ist Tod Mom. Ich bin zu seiner Testamentseröffnung eingeladen. Es ist morgen " +
				"um 13:00 Uhr. Ich werde von der Schule aus hin gehen.\"";
	}

}
