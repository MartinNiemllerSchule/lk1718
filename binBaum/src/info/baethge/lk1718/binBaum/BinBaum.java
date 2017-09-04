package info.baethge.lk1718.binBaum;

/**
 * Created by Administrator on 04.09.2017.
 */
public class BinBaum {
    private Knoten wurzel;
    public BinBaum() { wurzel = null; }

    public void einfügen(Knoten knoten) {
        if (wurzel == null) {
            wurzel = knoten;
        } else {
            wurzel.einfügenRek(knoten);
        }
    }

    @Override
    public String toString() {
        return "BinBaum{" +
                wurzel.ausgebenRek1() +
                '}';
    }
}
