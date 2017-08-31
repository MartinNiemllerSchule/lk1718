package info.baethge.lk1718.listen;

/**
 * doppelt verkettete Liste, die von der einfach verketteten Liste erbt
 */
public class ListeDoppeltVerkettet extends ListeEinfachVerkettet {

	public ListeDoppeltVerkettet() { super();	}
	public ListeDoppeltVerkettet(ElementDoppeltVerkettet element) {
		super(element);
	}

	/**
	 * ein Element anhängen
	 * @param element
	 */
	public void anhängen(ElementDoppeltVerkettet element) {
		if (erstes != null) {
			((ElementDoppeltVerkettet)erstes).anhängen(element);
		} else erstes = element;
	}

	/**
	 * ein Element vorher einfügen -> regelt auch das Problem ein Element vor dem ersten Element einzufügen
	 * @param name - Name des Elements vor dem eingefügt werden soll
	 * @param element - das einzufügende Element
	 */
	public void einfügenVor(int name, ElementDoppeltVerkettet element) {
		if (erstes.name == name) {
			element.vor = erstes;
			((ElementDoppeltVerkettet)erstes).zurück = element;
			erstes = element;
		} else {
			ElementDoppeltVerkettet vorheriges = (ElementDoppeltVerkettet)erstes.gibZeigtAuf(name);
			if (vorheriges != null) {
				vorheriges.einfügenNächstes(element);
			} // ich weiß nicht (hinten anhängen oder nicht?) else {}
		}
	}

	/**
	 * fügt das Element an der richtigen Stelle ein
	 * die Sortierordnung wird in ElementEinfachVerkettet festgelegt (hier nach name)
	 *
	 * @param element - zu suchendes Element
	 */
	public void sortiertEinfügen(ElementDoppeltVerkettet element) {
		if (erstes == null) {
			erstes = element;
		} else if (erstes.compareTo(element) > 0) {
			((ElementDoppeltVerkettet)erstes).zurück = element;
			element.vor = (ElementDoppeltVerkettet)erstes;
			erstes = element;
		}	else {
			ElementDoppeltVerkettet aktuell = (ElementDoppeltVerkettet) erstes;
			while (aktuell.vor != null && aktuell.vor.compareTo(element) < 0) aktuell = (ElementDoppeltVerkettet) aktuell.vor;
			if (aktuell.vor == null) { // anhängen
				aktuell.vor = element;
				element.zurück = aktuell;
			} else {
				aktuell.einfügenNächstes(element);
			}
		}
	}

	/**
	 * lösche das Element mit diesem Namen
	 * @param name
	 */
	public void lösche(int name) {
		ElementDoppeltVerkettet dieses = (ElementDoppeltVerkettet)erstes.gibZeigtAuf(name);
		if (dieses != null) {
			dieses.löscheNächstes();
		} else {
			if (erstes.name == name) {
				erstes = erstes.vor;
				((ElementDoppeltVerkettet)erstes).zurück = null;
			} // else -> das Element ist nicht in der Liste
		}
	}

	public String alleRückwärts() {
		ElementDoppeltVerkettet element = (ElementDoppeltVerkettet)erstes.letztesElement();
		String ergebnis = element.toString();
		while (element.zurück != null) {
			element = element.zurück;
			ergebnis += " " + element;
		}
		return ergebnis;
	}
}
