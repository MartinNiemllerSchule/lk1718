package info.baethge.lk1718.listen;

/**
 * Created by Felix on 30.08.2017.
 * Delegation
 */
public class Schlange {
    private ListeEinfachVerkettet liste;

    public Schlange() {
        liste = new ListeEinfachVerkettet();
    }

    public Schlange(ElementEinfachVerkettet element) {
        liste = new ListeEinfachVerkettet(element);
    }

    public void push(ElementEinfachVerkettet element) {
        liste.anhängen(element);
    }

    public int pop() {
        if (liste.erstes != null) {
            ElementEinfachVerkettet speicher = liste.erstes;
            liste.lösche(liste.erstes.name);
            return speicher.name;
        }   else return Integer.MIN_VALUE;
    }

    public ElementEinfachVerkettet read(){
        return liste.erstes;
    }

    @Override
    public String toString() {
        return liste.toString();
    }
}
