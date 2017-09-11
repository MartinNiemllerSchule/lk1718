package info.baethge.lk1718.binBaum;

public class Main {

	public static void main(String[] args) {
		try {
			Integer anzahl = 21000;
			if (args.length > 0) anzahl = Integer.parseInt(args[0]);

			BinBaum binBaum = new BinBaum("./data/adressdaten.csv", anzahl);

			System.out.println(binBaum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
/**
 * getestet mit
 * for i in {0..9}; do for j in {1..21}; do /usr/lib/jvm/default-java/bin/java -Dfile.encoding=UTF-8 -classpath /usr/lib/jvm/default-java/jre/lib/charsets.jar:/usr/lib/jvm/default-java/jre/lib/ext/cldrdata.jar:/usr/lib/jvm/default-java/jre/lib/ext/dnsns.jar:/usr/lib/jvm/default-java/jre/lib/ext/icedtea-sound.jar:/usr/lib/jvm/default-java/jre/lib/ext/jaccess.jar:/usr/lib/jvm/default-java/jre/lib/ext/java-atk-wrapper.jar:/usr/lib/jvm/default-java/jre/lib/ext/localedata.jar:/usr/lib/jvm/default-java/jre/lib/ext/nashorn.jar:/usr/lib/jvm/default-java/jre/lib/ext/sunec.jar:/usr/lib/jvm/default-java/jre/lib/ext/sunjce_provider.jar:/usr/lib/jvm/default-java/jre/lib/ext/sunpkcs11.jar:/usr/lib/jvm/default-java/jre/lib/ext/zipfs.jar:/usr/lib/jvm/default-java/jre/lib/jce.jar:/usr/lib/jvm/default-java/jre/lib/jsse.jar:/usr/lib/jvm/default-java/jre/lib/management-agent.jar:/usr/lib/jvm/default-java/jre/lib/resources.jar:/usr/lib/jvm/default-java/jre/lib/rt.jar:/home/frank/Programme/lk1718/binBaum/out/production/binBaum info.baethge.lk1718.binBaum.Main "${j}000" >> "${i}.csv"; done; done;
 * Mittelwerte in data/auswertung.ods
 */
