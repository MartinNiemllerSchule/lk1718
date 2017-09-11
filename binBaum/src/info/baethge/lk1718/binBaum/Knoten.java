package info.baethge.lk1718.binBaum;

/**
 * ein Knoten im sortierten binären Baum
 * 04.09.2017.
 */
public class Knoten implements Comparable<Knoten> {
	private Adresse adresse;
	private Knoten links, rechts;

	public Knoten() {
		adresse = null;
		links = null;
		rechts = null;
	}

	public Knoten(Adresse adresse) {
		this.adresse = adresse;
		links = null;
		rechts = null;
	}

	protected void add(Knoten knoten) {
		if (compareTo(knoten) == 0) {
			// tue nichts
		} else if (compareTo(knoten) < 0) {
			if (links != null) {
				links.add(knoten);
			} else {
				links = knoten;
			}
		} else {
			if (rechts != null) {
				rechts.add(knoten);
			} else {
				rechts = knoten;
			}
		}
	}

	protected String alleAusgebenInorder() {
		String linksText = "";
		if (links != null) linksText = links.alleAusgebenInorder();

		String rechtsText = "";
		if (rechts != null) rechtsText = rechts.alleAusgebenInorder();

		return linksText + ' ' + adresse.toString() + "\n" + rechtsText;
	}

	@Override
	public int compareTo(Knoten o) {
		return o.adresse.compareTo(adresse);
	}

	@Override
	public String toString() {
		return adresse.toString() + "\n";
	}
}
