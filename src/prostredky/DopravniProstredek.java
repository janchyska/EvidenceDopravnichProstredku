package prostredky;

import java.io.Serializable;
import java.util.Objects;
import prostredky.*;

public class DopravniProstredek implements Serializable, Comparable, Cloneable {

    private final DopravniProstredekTyp typNazev;
    private int hmotnost;
    private String spz;
    private int vykon;
    private final int id;

    public DopravniProstredek(int id, DopravniProstredekTyp typNazev, String spz,
            int hmotnost, int vykon) {
        this.id = id;
        this.typNazev = typNazev;
        this.spz = spz;
        this.vykon = vykon;
        this.hmotnost = hmotnost;
    }

    public DopravniProstredek(DopravniProstredekTyp typNazev, String spz,
            int hmotnost, int vykon) {
        this((int) (Math.random() * 9999), typNazev, spz, vykon, hmotnost);
    }

    public DopravniProstredekTyp getTypNazev() {
        return typNazev;
    }

    public int getId() {
        return id;
    }

    public int getHmotnost() {
        return hmotnost;
    }

    public void setHmotnost(int hmotnost) {
        this.hmotnost = hmotnost;
    }

    public String getSpz() {
        return spz;
    }

    public void setSpz(String spz) {
        this.spz = spz;
    }

    public int getVykon() {
        return vykon;
    }

    public void setVykon(int vykon) {
        this.vykon = vykon;
    }

    @Override
    public String toString() {
        return "id=" + id + ", " + getTypNazev() + ", spz=" + getSpz()
                + ", výkon=" + getVykon() + ", hmotnost=" + getHmotnost() + ", ";
    }

    public String toTextFile() {
        return getTypNazev() + ", " + getSpz() + ", " + getVykon() + ", " + getHmotnost() + ", ";
    }

    @Override
    public int compareTo(Object o) {
        Objects.requireNonNull(o);
        DopravniProstredek dopravniProstredek = (DopravniProstredek) o;
        int c = typNazev.getTypNazev().compareTo(dopravniProstredek.typNazev.getTypNazev());
        if (c == 0) {
            return Integer.compare(id, dopravniProstredek.id);
        } else {
            return c;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
