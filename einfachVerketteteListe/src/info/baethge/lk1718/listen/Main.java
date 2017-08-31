package info.baethge.lk1718.listen;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// Liste mit 1, 2, 3 aufbauen
		ListeEinfachVerkettet liste = new ListeEinfachVerkettet(new ElementEinfachVerkettet(1));
		liste.anhängen(new ElementEinfachVerkettet(2));
		liste.anhängen(new ElementEinfachVerkettet(3));
		System.out.println(String.format("%25s: %s","Liste 1, 2, 3",liste));

		// 4 vor 3 einfügen
		liste.einfügenVor(3, new ElementEinfachVerkettet(4));
		System.out.println(String.format("%25s: %s","4 vor 3 einfügen",liste));

		// 5 hinten anhängen
		liste.anhängen(new ElementEinfachVerkettet(5));
		System.out.println(String.format("%25s: %s","5 hinten anhängen",liste));

		// 3 löschen
		liste.lösche(3);
		System.out.println(String.format("%25s: %s","3 löschen",liste));

		// erstes Element löschen
		liste.lösche(1);
		System.out.println(String.format("%25s: %s","1 löschen",liste));

		// liste rückwärts ausgeben
		System.out.println(String.format("%25s: %s","rückwärts rekursiv",liste.rückwärtsRekursiv()));
		System.out.println(String.format("%25s: %s","rückwärts iterativ",liste.rückwärtsIterativ()));

		// und nun alles nochmal mit der doppelt verkettete Liste
		System.out.println("\ndoppelt verkettete Liste\n");
		// Liste mit 1, 2, 3 aufbauen
		ListeDoppeltVerkettet dliste = new ListeDoppeltVerkettet(new ElementDoppeltVerkettet(1));
		dliste.anhängen(new ElementDoppeltVerkettet(2));
		dliste.anhängen(new ElementDoppeltVerkettet(3));
		System.out.println(String.format("%25s: %s","Liste 1, 2, 3",dliste));

		// 4 vor 3 einfügen
		dliste.einfügenVor(3, new ElementDoppeltVerkettet(4));
		System.out.println(String.format("%25s: %s","4 vor 3 einfügen",dliste));

		// 5 hinten anhängen
		dliste.anhängen(new ElementDoppeltVerkettet(5));
		System.out.println(String.format("%25s: %s","5 hinten anhängen",dliste));
		System.out.println(String.format("%25s: %s","rückwärts",dliste.alleRückwärts()));

		// 3 löschen
		dliste.lösche(3);
		System.out.println(String.format("%25s: %s","3 löschen",dliste));

		// erstes Element löschen
		dliste.lösche(1);
		System.out.println(String.format("%25s: %s","1 löschen",dliste));

		// liste rückwärts ausgeben
		System.out.println(String.format("%25s: %s","rückwärts",dliste.alleRückwärts()));


		// Schlange (FiFo)
		System.out.println("\nSchlange\n");
		Schlange schlange = new Schlange(new ElementEinfachVerkettet(1));
		schlange.push(new ElementEinfachVerkettet(2));
		schlange.push(new ElementEinfachVerkettet(3));
		schlange.push(new ElementEinfachVerkettet(4));
		System.out.println(String.format("%25s: %s","schlange",schlange));
		System.out.println(String.format("%25s: %s","pop ergebnis",schlange.pop()));
		System.out.println(String.format("%25s: %s","pop rest:",schlange));
		System.out.println(String.format("%25s: %s","read ergebnis",schlange.read()));
		System.out.println(String.format("%25s: %s","schlange",schlange));
		System.out.println(String.format("%25s: %s","pop ergebnis",schlange.pop()));
		System.out.println(String.format("%25s: %s","pop ergebnis",schlange.pop()));
		System.out.println(String.format("%25s: %s","pop ergebnis",schlange.pop()));
		System.out.println(String.format("%25s: %s","schlange",schlange));
		System.out.println(String.format("%25s: %s","pop ergebnis",schlange.pop()));

		// binäre Suche
		System.out.println("\nbinäre Suche\n");
		final int ANZAHL = 1000;
		BinäreSuche binäreSuche = new BinäreSuche(ANZAHL);
		System.out.println(String.format("%25s: %s","sortierte Liste erstellt",binäreSuche));

		Random random = new Random();
		int anzahl = 0;
		while (binäreSuche.binäreSuche(random.nextInt(10000)) == null) anzahl++;
		System.out.println(String.format("%25s: %d %s","erster Suchtreffer nach", anzahl, "Versuchen"));
		/*
		for (int i = 1; i <= ANZAHL; i++) {
			System.out.println(String.format("%20s: %s",String.format("suche % 4d",i),binäreSuche.binäreSuche(i)));
		}
 		*/


	}
}
