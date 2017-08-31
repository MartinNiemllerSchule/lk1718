package info.baethge.lk1718.listen;

import java.util.Random;

/**
 * Umsetzung der binären Suche auf einer doppelt verketteten Liste
 * die Liste wird mit 1000 Elementen gefüllt
 */
public class BinäreSuche extends ListeDoppeltVerkettet {
	private int anzahl;
	public BinäreSuche(int anzahl) {
		super();

		// Zufallselemente
		Random random = new Random();
		for (int i = 1; i <= anzahl; i++) {
			sortiertEinfügen(new ElementDoppeltVerkettet(random.nextInt(10000)));
		}
		this.anzahl = anzahl;
	}

	public ElementDoppeltVerkettet binäreSuche(int suche) {
		int anzSchritte = anzahl / 2 - 1;
		ElementDoppeltVerkettet aktuell = ((ElementDoppeltVerkettet)erstes).gehe(anzSchritte);
		return aktuell.binSuche(suche, -anzSchritte - 1, anzSchritte + 2 + (anzahl % 2));
	}
}
