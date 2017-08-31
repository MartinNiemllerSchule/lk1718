package info.baethge.lk1718.listen;

/**
 * Created by frank on 29.08.17.
 */
public class ElementDoppeltVerkettet extends ElementEinfachVerkettet {
	ElementDoppeltVerkettet zurück;
	/**
	 * Konstruktor
	 *
	 * @param name - die Namen sind in unserem Fall nur Zahlen
	 */
	protected ElementDoppeltVerkettet(int name) {
		super(name);
		zurück = null;
	}

	/**
	 * hängt ein Element an
	 * @param element - das einzufügende Element
	 */
	protected void anhängen(ElementDoppeltVerkettet element) {
		ElementDoppeltVerkettet aktuell = (ElementDoppeltVerkettet)letztesElement();
		aktuell.vor = element;
		element.zurück = aktuell;
	}

	/**
	 * löscht das nächste Element
	 */
	@Override
	protected void löscheNächstes() {
		((ElementDoppeltVerkettet)vor.vor).zurück = this;
		vor = vor.vor;
	}

	/**
	 * fügt das Element an dieser (this) Stelle in die Liste ein
	 * @param element - einzufügendes Element
	 */
	protected void einfügenNächstes(ElementDoppeltVerkettet element) {
		element.vor = vor;
		element.zurück = this;
		((ElementDoppeltVerkettet)vor).zurück = element;
		vor = element;
	}


	/**
	 * geht durch die Liste soundsoviel Elemente nach links oder rechts
	 * @param anzahlSchritte
	 * @return
	 */
	protected ElementDoppeltVerkettet gehe(int anzahlSchritte) {
		ElementDoppeltVerkettet aktuell = this;
		int aS = anzahlSchritte;
		if (aS < 0) {
			while (aS < 0 && aktuell.zurück != null) {
				aktuell = aktuell.zurück;
				aS++;
			}
		} else {
			while (aS > 0 && aktuell.vor != null) { aktuell = (ElementDoppeltVerkettet) aktuell.vor; aS--; }
		}
		if (aS == 0) {
			return aktuell;
		} else {
			throw new IndexOutOfBoundsException("Die Grenzen der Liste sollten überschritten werden");
		}
	}
	protected ElementDoppeltVerkettet binSuche (int suchBegriff, int linksVorher, int rechtsVorher) {
		if (name == suchBegriff) {
			return this;
		} else {
			int anzSchritte;
			ElementDoppeltVerkettet aktuell;
			if (suchBegriff < name) {
				if (linksVorher < -1) {
					anzSchritte = linksVorher / 2;
					aktuell = gehe(anzSchritte);
					return aktuell.binSuche(suchBegriff, linksVorher - anzSchritte, -anzSchritte);
				} else return null;
			} else {
				if (rechtsVorher > 1) {
					anzSchritte = rechtsVorher / 2;
					aktuell = gehe(anzSchritte);
					return aktuell.binSuche(suchBegriff, -anzSchritte, rechtsVorher - anzSchritte);
				} else return null;
			}
		}
	}

}
