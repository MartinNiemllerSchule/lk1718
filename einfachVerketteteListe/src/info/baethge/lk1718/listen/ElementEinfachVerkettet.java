package info.baethge.lk1718.listen;

/**
 * Demonstration von Vererbung und
 * Funktionsweise von einfach verketteten Listen
 * ein Element ist Teil der Liste
 */
public class ElementEinfachVerkettet {
	protected int name;
	protected ElementEinfachVerkettet vor;

	/**
	 * Konstruktor
	 * @param name - die Namen sind in unserem Fall nur Zahlen
	 */
	protected ElementEinfachVerkettet(int name) {
		this.name = name;
		vor = null;
	}

	/**
	 * findet das letzte Element der Liste
	 * @return - letztes Element
	 */
	protected ElementEinfachVerkettet letztesElement() {
		ElementEinfachVerkettet aktuell = this;
		while (aktuell.vor != null) aktuell = aktuell.vor;
		return aktuell;
	}

	/**
	 * hängt ein Element an
	 * @param element - das einzufügende Element
	 */
	protected void anhängen(ElementEinfachVerkettet element) {
		ElementEinfachVerkettet aktuell = letztesElement();
		aktuell.vor = element;
	}

	/**
	 * Hilfsfunktion, die das Element vor dem Element mit diesem Namen zeigt, ergibt
	 * @param name - Name des Elements das als Auswahlkriterium fungiert
	 * @return - null, falls das Element mit dem Auswahlkriterium nicht existert, sonst das Element, das darauf zeigt
	 */
	protected ElementEinfachVerkettet gibZeigtAuf(int name) {
		ElementEinfachVerkettet akt = this;
		while (akt.vor != null && akt.vor.name != name) akt = akt.vor;
		if(akt.vor == null) {
			return null;
		} else {
			return akt;
		}
	}

	/**
	 * löscht das nächste Element
	 */
	protected void löscheNächstes() {
		vor = vor.vor;
	}

	/**
	 * fügt das Element an dieser (this) Stelle in die Liste ein
	 * @param element - einzufügendes Element
	 */
	protected void einfügenNächstes(ElementEinfachVerkettet element) {
		element.vor = vor;
		vor = element;
	}

	@Override
	public String toString() {
		return "" + name;
	}

	/**
	 * gibt eine Text für die gesamte anhängende Liste zurück
	 * @return
	 */
	protected String alle() {
		String ergebnis = this.toString();
		ElementEinfachVerkettet akt = this;
		while (akt.vor != null) {
			akt = akt.vor;
			ergebnis += " " + akt.toString();
		}
		return ergebnis;
	}
}