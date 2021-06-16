package sprava;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import kolekce.*;
import perzistence.*;
import prostredky.*;

/**
 *
 * @author janch
 */
public class SpravaProstredku implements Ovladani<DopravniProstredek> {

    private Seznam<DopravniProstredek> seznam;
    private Comparator<? super DopravniProstredek> komparator;

    @Override
    public void vytvorSeznam(Supplier<Seznam<DopravniProstredek>> supplier) {
        seznam = supplier.get();
    }

    @Override
    public void vytvorSeznam(Function<Integer, Seznam<DopravniProstredek>> function, int size) throws KolekceException {
        seznam = new LinSeznam<>();
        for (int i = 0; i < size; i++) {
            seznam.vlozNaKonec(null);
        }
    }

    @Override
    public void nastavKomparator(Comparator<? super DopravniProstredek> comparator) {
        komparator = comparator;
    }

    @Override
    public void vlozPolozku(DopravniProstredek data) throws NullPointerException {
        if (data == null) {
            throw new NullPointerException();
        } else {
            seznam.vlozNaKonec(data);
        }

    }

    @Override
    public DopravniProstredek najdiPolozku(DopravniProstredekKlic klic) {
        if (klic.getSpz() == null) {
            return null;
        }
        Object[] object = stream().filter(dopravniProstredek -> (klic.getId() == 0
                || klic.getId() == dopravniProstredek.getId())
                && (klic.getSpz().isEmpty() || klic.getSpz().equals(dopravniProstredek.getSpz()))).toArray();
        if (object.length > 0) {
            return (DopravniProstredek) object[0];
        }
        System.err.print("Dle klíče nebyli nalezeny žádné položky!");
        return null;

    }

    @Override
    public void prejdiNaPrvniPolozku() {
        try {
            seznam.nastavPrvni();
            System.out.println("První prostředek v seznamu byl nastaven jako aktuální.");
        } catch (KolekceException ex) {
            System.err.println("Nepovedlo se nastavit první prostředek jako aktuální.");
        }
    }

    @Override
    public void prejdiNaPosledniPolozku() {
        try {
            seznam.nastavPosledni();
            System.out.println("Poslední prostředek v seznamu byl nastaven jako aktuální.");
        } catch (KolekceException ex) {
            System.err.println("Nepovedlo se nastavit poslední prostředek jako aktuální.");
        }
    }

    @Override
    public void prejdiNaDalsiPolozku() {
        try {
            seznam.dalsi();
            System.out.println("Další prostředek  v seznamu byl nastaven jako aktuální.");
        } catch (KolekceException e) {
            System.err.println("Nepovedlo se nastavit další prostředek jako aktuální.");
        }
    }

    @Override
    public void prejdiNaPredchoziPolozku() {
        DopravniProstredek aktualni = null;
        try {
            aktualni = seznam.dejAktualni();
            seznam.nastavPrvni();
            while (seznam.dejZaAktualnim() != aktualni) {
                seznam.dalsi();
            }
            System.out.println("Předchozí prostředek byl nastaven jako aktuální.");
        } catch (KolekceException ex) {
            System.err.println("Nepovedlo se nastavit předchozí prostředek jako aktuální.");
        }
    }

    @Override
    public DopravniProstredek nastavAktualniPolozku(DopravniProstredekKlic klic) {
      try {
            String spz = klic.getSpz();
            int id = klic.getId();
            if (spz.isEmpty() && id == 0) return null;
            seznam.nastavPrvni();
            for (int i = 0; i < seznam.size(); i++) {
                DopravniProstredek aktualni = seznam.dejAktualni();
                if ((id == 0 || id == aktualni.getId()) && (spz.isEmpty() || spz.equals(aktualni.getSpz())))
                    return seznam.dejAktualni();
                seznam.dalsi();
            }
        } catch (KolekceException ex) {
             System.err.print("Nepodařilo se nastavit aktuální položku.");
        }

       
        return null;
    }

    @Override
    public DopravniProstredek vyjmiAktualniPolozku() {
        try {
            return seznam.odeberAktualni();
        } catch (KolekceException ex) {
            return null;
        }

    }

    @Override
    public DopravniProstredek dejKopiiAktualniPolozky() {
        try {
            return (DopravniProstredek) seznam.dejAktualni().clone();
        } catch (CloneNotSupportedException | KolekceException ex) {
            return null;
        }
    }

    @Override
    public void editujAktualniPolozku(Function<DopravniProstredek, DopravniProstredek> editor) {
        try {
            DopravniProstredek aktualni = seznam.dejAktualni();
            command.editor.edit(aktualni);
        } catch (KolekceException ex) {
            System.err.println("Nepovedlo se upravit dopravní prostředek.");
        }

    }

    @Override
    public void ulozDoSouboru(String soubor) {
        try {
           PerzistenceUloz.zalohujBin(soubor, seznam);
        } catch (IOException ex) {
        } catch (KolekceException ex) {
        }
    }

    @Override
    public void nactiZeSouboru(String soubor) {

        try {
            PerzistenceNacti.obnovBin(soubor, seznam);
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    @Override
    public void vypis(Consumer<DopravniProstredek> writer) {
        stream().forEach(writer);
    }

    @Override
    public void nactiTextSoubor(String soubor, Function<String, DopravniProstredek> mapper) {
        try {
            PerzistenceNacti.nactiText(seznam, mapper, soubor);
            System.out.println("Položky z textového souboru se povedlo úspěšně načíst a přidat do seznamu.");
        } catch (IOException ex) {
        }
    }

    @Override
    public void ulozTextSoubor(String soubor, Function<DopravniProstredek, String> mapper) {
        try {
            PerzistenceUloz.ulozText(seznam, soubor);
        } catch (KolekceException ex) {
        } catch (IOException ex) {
        }
    }

    @Override
    public void generujData(int pocetProstredku) {
        for (int i = 0; i < pocetProstredku; i++) {
            DopravniProstredek dopravniProstredek = null;
            dopravniProstredek = generator.Generator.generujDopravniProstredek();
            seznam.vlozNaKonec(dopravniProstredek);
        }
    }

    @Override
    public int dejAktualniPocetPolozek() {
        return seznam.size();
    }

    @Override
    public void zrus() {
        seznam.zrus();
    }

    @Override
    public Iterator<DopravniProstredek> iterator() {
        return seznam.iterator();
    }

}
