package info.baethge.lk1718.binBaum;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BinBaum binBaum = new BinBaum();
        binBaum.einfügen(new Knoten(14));
        binBaum.einfügen(new Knoten(22));
        binBaum.einfügen(new Knoten(37));
        binBaum.einfügen(new Knoten(48));
        binBaum.einfügen(new Knoten(39));
        binBaum.einfügen(new Knoten(50));
        binBaum.einfügen(new Knoten(11));
        binBaum.einfügen(new Knoten(25));
        binBaum.einfügen(new Knoten(12));
        binBaum.einfügen(new Knoten(27));
        binBaum.einfügen(new Knoten(49));
        binBaum.einfügen(new Knoten(39));

        System.out.println(binBaum);
    }
}
