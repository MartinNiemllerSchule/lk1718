package info.baethge.lk1718.binBaum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * sortierter binäerer Baum aus Adressen
 * 04.09.2017.
 */
public class BinBaum {
	private Knoten wurzel;
	private Integer anzahlMax;
	private Long startZeit, endZeit;

	/**
	 * liest gleichzeitig die benannte Datei ein und baut daraus den Baum, der dann schon sortiert vorliegt
	 *
	 * @param dateiName - data/adressen.csv
	 * @param anzahlMax
	 */
	public BinBaum(String dateiName, Integer anzahlMax) {
		wurzel = null;
		this.anzahlMax = anzahlMax;

    	/* einlesen der Datei
    	* erfolgt erstmal in eine ArrayList, damit der Zeitaufwand der Sortierung besser abgeschätzt werden kann
    	* und nicht mit dem Öffnen der Datei und dem Lesen daraus vermischt wird
    	 */
		List<Adresse> adressen = new ArrayList<>(this.anzahlMax);
		int anzahl = this.anzahlMax;
		BufferedReader br;
		try {
			FileReader fr = new FileReader(dateiName);
			br = new BufferedReader(fr);
			String zeile;
			while (((zeile = br.readLine()) != null) && (anzahl-- > 0)) {
				adressen.add(new Adresse(zeile.split(",")));
			}

			startZeit = System.currentTimeMillis();
			// einfügen aller Adressen
			wurzel = new Knoten(adressen.remove(0));
			while (adressen.size() > 0) wurzel.add(new Knoten(adressen.remove(0)));
			endZeit = System.currentTimeMillis();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return
		        /*"BinBaum{\n" + wurzel.alleAusgebenInorder() + "}\n" +*/
				anzahlMax.toString() + "," + (endZeit - startZeit);
	}
}
