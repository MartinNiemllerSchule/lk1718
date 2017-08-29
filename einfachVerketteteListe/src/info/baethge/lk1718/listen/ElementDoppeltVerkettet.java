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

}
