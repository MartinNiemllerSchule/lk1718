package info.baethge.lk1718.binBaum;

/**
 * Created by Administrator on 04.09.2017.
 */
public class Knoten implements Comparable<Knoten> {
    private Integer name;
    private Knoten links, rechts;
    public Knoten() {
        name = null;
        links = null;
        rechts = null;
    }
    public Knoten(Integer name) {
        this.name = name;
        links = null;
        rechts = null;
    }

    protected void einfügenRek(Knoten knoten) {
        if (compareTo(knoten) == 0) {
            // tue nichts
        } else if (compareTo(knoten) < 0 ) {
            if (links != null) {
                links.einfügenRek(knoten);
            } else {
                links = knoten;
            }
        } else {
            if (rechts != null) {
                rechts.einfügenRek(knoten);
            } else {
                rechts = knoten;
            }
        }
    }

    protected String ausgebenRek1() {
        String linksText = "";
        if (links != null) linksText = links.ausgebenRek1();

        String rechtsText = "";
        if (rechts != null) rechtsText = rechts.ausgebenRek1();

        return linksText + ' ' + name.toString() + ' '  + rechtsText;
    }

    @Override
    public int compareTo(Knoten o) {
        return o.name.compareTo(name);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
