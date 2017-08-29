package info.baethge.lk1718.listen;

public class Main {

	public static void main(String[] args) {
		// Liste mit 1, 2, 3 aufbauen
		ListeEinfachVerkettet liste = new ListeEinfachVerkettet(new ElementEinfachVerkettet(1));
		liste.anhängen(new ElementEinfachVerkettet(2));
		liste.anhängen(new ElementEinfachVerkettet(3));
		System.out.println("     Liste 1, 2, 3: " + liste);

		// 4 vor 3 einfügen
		liste.einfügenVor(3, new ElementEinfachVerkettet(4));
		System.out.println("  4 vor 3 einfügen: " + liste);

		// 5 hinten anhängen
		liste.anhängen(new ElementEinfachVerkettet(5));
		System.out.println(" 5 hinten anhängen: " + liste);

		// 3 löschen
		liste.lösche(3);
		System.out.println("         3 löschen: " + liste);

		// erstes Element löschen
		liste.lösche(1);
		System.out.println("         1 löschen: " + liste);

		// liste rückwärts ausgeben
		System.out.println("rückwärts rekursiv: " + liste.rückwärtsRekursiv());
		System.out.println("rückwärts iterativ: " + liste.rückwärtsIterativ());

		// und nun alles nochmal mit der doppelt verkettete Liste
		System.out.println("\ndoppelt verkettete Liste\n");
		// Liste mit 1, 2, 3 aufbauen
		ListeDoppeltVerkettet dliste = new ListeDoppeltVerkettet(new ElementDoppeltVerkettet(1));
		dliste.anhängen(new ElementDoppeltVerkettet(2));
		dliste.anhängen(new ElementDoppeltVerkettet(3));
		System.out.println("     Liste 1, 2, 3: " + dliste);

		// 4 vor 3 einfügen
		dliste.einfügenVor(3, new ElementDoppeltVerkettet(4));
		System.out.println("  4 vor 3 einfügen: " + dliste);

		// 5 hinten anhängen
		dliste.anhängen(new ElementDoppeltVerkettet(5));
		System.out.println(" 5 hinten anhängen: " + dliste);
		System.out.println("         rückwärts: " + dliste.alleRückwärts());

		// 3 löschen
		dliste.lösche(3);
		System.out.println("         3 löschen: " + dliste);

		// erstes Element löschen
		dliste.lösche(1);
		System.out.println("         1 löschen: " + dliste);

		// liste rückwärts ausgeben
		System.out.println("         rückwärts: " + dliste.alleRückwärts());



	}
}
