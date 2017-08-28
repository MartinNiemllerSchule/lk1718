package info.baethge.lk1718.listen;

/**
 * einfach verkettete Liste aus Objekten vom Typ ElementEinfachVerkettet
 */
public class ListeEinfachVerkettet {
	private ElementEinfachVerkettet erstes;

	/**
	 * Konstruktoren
	 */
	public ListeEinfachVerkettet() { erstes = null; }
	public ListeEinfachVerkettet(ElementEinfachVerkettet element) {
		if (erstes == null) {
			erstes = element;
		} else {
			erstes.anhängen(element);
		}
	}

	/**
	 * ein Element anhängen
	 * @param element
	 */
	public void anhängen(ElementEinfachVerkettet element) {
		if (erstes != null) {
			erstes.anhängen(element);
		} else erstes = element;
	}

	/**
	 * ein Element vorher einfügen -> regelt auch das Problem ein Element vor dem ersten Element einzufügen
	 * @param name - Name des Elements vor dem eingefügt werden soll
	 * @param element - das einzufügende Element
	 */
	public void einfügenVor(int name, ElementEinfachVerkettet element) {
		if (erstes.name == name) {
			element.vor = erstes;
			erstes = element;
		} else {
			ElementEinfachVerkettet vorheriges = erstes.gibZeigtAuf(name);
			if (vorheriges != null) {
				vorheriges.einfügenNächstes(element);
			} // ich weiß nicht (hinten anhängen oder nicht?) else {}
		}
	}

	/**
	 * lösche das Element mit diesem Namen
	 * @param name
	 */
	public void lösche(int name) {
		ElementEinfachVerkettet dieses = erstes.gibZeigtAuf(name);
		if (dieses != null) {
			dieses.löscheNächstes();
		} else {
			if (erstes.name == name) {
				erstes = erstes.vor;
			} // else -> das Element ist nicht in der Liste
		}
	}

	/**
	 * Liste rückwärts ausgeben - rekursiv programmiert
	 * das dürfte zu Problemen führen, wenn die Liste zu lang wird (Arbeitspeicher)
	 * Zeitkomplexität O(n)
	 * @return
	 */
	public String rückwärtsRekursiv() {
		return rRekursiv(erstes);
	}

	/**
	 * Hilfsfunktion für das rekursive Rückwärtsausgeben
	 * @param aktuell
	 * @return
	 */
	private String rRekursiv(ElementEinfachVerkettet aktuell) {
		if (aktuell.vor != null) {
			return rRekursiv(aktuell.vor) + " " + aktuell.name;
		} else return String.valueOf(aktuell.name);
	}

	/**
	 * iteratives Rückwärtsausgeben der Liste
	 * hat aber ein Zeitproblem bei langen Listen, weil jede Liste immer wieder von vorn durchsucht werden muss
	 * Zeitkomplexität: O(n²)
	 * @return
	 */
	public String rückwärtsIterativ() {
		ElementEinfachVerkettet aktuell = erstes.letztesElement();
		String ergebnis = "";
		while (aktuell != erstes){
			ergebnis += aktuell.name + " ";
			aktuell = erstes.gibZeigtAuf(aktuell.name);
		}
		return ergebnis + aktuell.name;
	}
	@Override
	public String toString() {
		if (erstes != null)	return erstes.alle();
		return "Die Liste ist leer.";
	}
}
