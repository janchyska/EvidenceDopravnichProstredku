package kolekce;

import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author janch
 * @param <E>
 */
public class LinSeznam<E> implements Seznam<E> {

    private Prvek<E> prvni, posledni, aktualni;
    private int i = 0;

    public LinSeznam() {

    }

    private static class Prvek<E> {

        private Prvek<E> dalsi;
        private E data;

        public Prvek(E data) {
            this.data = data;
        }
    }

    @Override
    public void nastavPrvni() throws KolekceException {
        if (jePrazdny()) {
            throw new KolekceException();
        } else {
            aktualni = prvni;
        }
    }

    @Override
    public void nastavPosledni() throws KolekceException {
        if (jePrazdny()) {
            throw new KolekceException();
        } else {

            aktualni = posledni;
        }
    }

    @Override
    public boolean dalsi() throws KolekceException {
        if (dejAktualni() == null) {
            throw new KolekceException();
        }
        if (jePrazdny()) {
            return false;
        }
        if (aktualni.dalsi == null) {
            throw new KolekceException();
        } else {
            aktualni = aktualni.dalsi;
            return true;
        }

    }

    @Override
    public void vlozPrvni(E data) {
        Objects.requireNonNull(data);
        if (data == null) {
            throw new NullPointerException();
        } else if (jePrazdny()) {
            Prvek prvek = new Prvek<E>(data);
            prvni = prvek;
            posledni = prvni;
        } else if (prvni == posledni) {
            Prvek prvek = new Prvek<E>(data);
            Prvek oldFirst = prvni;
            prvni = prvek;
            prvni.dalsi = oldFirst;
            prvni.dalsi = posledni;
        } else { 
            Prvek prvek = new Prvek<E>(data);
            Prvek oldFirst = prvni;
            Prvek zaPuvodnimPrvnim = prvni.dalsi;
            prvni = prvek;
            prvni.dalsi = oldFirst;
            prvni.dalsi.dalsi = zaPuvodnimPrvnim;
        }
        i++;
    }

    @Override
    public void vlozNaKonec(E data) {
        Objects.requireNonNull(data);
        if (data == null) {
            throw new NullPointerException();
        }
        if (jePrazdny()) {
            vlozPrvni(data);
        } else if (aktualni == posledni) {
            Prvek novyPrvek = new Prvek<E>(data);
            aktualni.dalsi = novyPrvek;
            posledni = novyPrvek;
            i++;
        } else {
            Prvek novyPrvek = new Prvek<E>(data);
            posledni.dalsi = novyPrvek;
            posledni = posledni.dalsi;

            i++;
        }

    }

    @Override
    public void vlozZaAktualni(E data) throws KolekceException {
        Objects.requireNonNull(data);

        if (aktualni == null) {
            throw new KolekceException();
        }
        if (jePrazdny()) {
            vlozPrvni(data);
        } else if (aktualni == posledni) {
            Prvek novyPrvek = new Prvek<E>(data);
            aktualni.dalsi = novyPrvek;
            posledni = novyPrvek;
        } else {
            Prvek novyPrvek = new Prvek<E>(data);
            Prvek zaAktualnimOld = aktualni.dalsi;
            Prvek puvodniAktualni = aktualni;
            aktualni.dalsi = novyPrvek;
            Prvek prosteDalsi;
            do {
                dalsi();
                prosteDalsi = aktualni.dalsi;
                aktualni.dalsi = zaAktualnimOld;
            } while (aktualni.dalsi != posledni);
            aktualni = puvodniAktualni;
        }
        i++;
    }

    @Override
    public boolean jePrazdny() {
        if (Objects.isNull(this.prvni)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public E dejPrvni() throws KolekceException {
        if (jePrazdny()) {
            throw new KolekceException();
        } else {
            return prvni.data;
        }
    }

    @Override
    public E dejPosledni() throws KolekceException {
        if (jePrazdny()) {
            throw new KolekceException();
        }
        if (prvni == posledni) {
            E data = prvni.data;
            return data;
        } else {
            while (prvni.dalsi != null) {
                prvni = prvni.dalsi;
            }
            posledni = prvni;
            return posledni.data;
        }
    }

    @Override
    public E dejAktualni() throws KolekceException {
        if (jePrazdny() || aktualni == null) {
            throw new KolekceException();
        } else {
            return aktualni.data;
        }
    }

    @Override
    public E dejZaAktualnim() throws KolekceException {
        if (jePrazdny() || aktualni == null) {
            throw new KolekceException();
        } else {
            return aktualni.dalsi.data;
        }
    }

    @Override
    public E odeberAktualni() throws KolekceException {
        if (jePrazdny()) {
            throw new KolekceException();
        } else if (prvni == posledni && prvni != aktualni) {
            throw new KolekceException();
        } else if (aktualni == null) {
            throw new KolekceException();
        } else {
            if (aktualni == prvni) {
                if (jePrazdny()) {
                    throw new KolekceException();
                } else if (prvni == posledni) {
                    E Data = prvni.data;
                    aktualni = null;
                    zrus();
                    i = 0;
                    return Data;
                } else {
                    E Data = prvni.data;
                    prvni = prvni.dalsi;
                    aktualni = null;
                    i--;
                    return Data;
                }
            } else if (aktualni == posledni) {
                if (jePrazdny()) {
                    throw new KolekceException();
                } else if (prvni == posledni) {
                    E Data = posledni.data;
                    aktualni = null;
                    zrus();
                    i = 0;
                    return Data;
                } else {
                    E Data = posledni.data;
                    posledni = null;
                    aktualni = null;
                    i--;
                    return Data;
                }
            } else {
                E Data = aktualni.data;
                Prvek<E> dalsi = aktualni.dalsi;
                Prvek<E> predchozi = prvni;
                if (predchozi != aktualni && predchozi.dalsi != aktualni) {
                    predchozi = predchozi.dalsi;
                }
                predchozi.dalsi = dalsi;
                aktualni = null;
                i--;
                return Data;
            }
        }
    }

    @Override
    public E odeberZaAktualnim() throws KolekceException {
        if (jePrazdny()) {
            throw new KolekceException();
        }
        if (aktualni == null) {
            throw new KolekceException();
        }
        if (posledni == aktualni) {
            throw new KolekceException();
        }
        if (prvni == posledni && prvni == aktualni) {
            throw new KolekceException();
        }
        if (aktualni != posledni) {
            E Data = aktualni.dalsi.data;
            Prvek zaAktualnimOdebranym = aktualni.dalsi.dalsi;
            aktualni.dalsi = null;
            aktualni.dalsi = zaAktualnimOdebranym;
            i--;
            return Data;
        } else {
            throw new KolekceException();
        }
    }

    @Override
    public int size() {
        return i;
    }

    @Override
    public void zrus() {
        this.aktualni = null;
        this.posledni = null;
        this.prvni = null;
        i = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Prvek interItem = prvni;
            boolean posledni = false;

            @Override
            public boolean hasNext() {
                if (jePrazdny()) {
                    return false;
                }
                if (interItem.dalsi == null) {
                    if (posledni == false) {
                        posledni = true;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return true;
                }
            }

            @Override
            public E next() {
                E Data = (E) interItem.data;
                if (posledni == false) {
                    interItem = interItem.dalsi;
                }
                return Data;
            }
        };
    }
}
