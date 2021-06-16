package perzistence;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Objects;
import kolekce.KolekceException;
import kolekce.*;
import prostredky.*;

/**
 *
 * @author janch
 */
public class PerzistenceUloz {

    public static <DopravniProstredek> void zalohujBin(String soubor, Seznam<DopravniProstredek> seznam) throws IOException, KolekceException {
        ulozBin(soubor, seznam);
    }

    public static void ulozText(Seznam<DopravniProstredek> seznam, String soubor) throws IOException, KolekceException {
        ulozTxt(seznam, soubor);
    }

    private static <DopravniProstredek> void ulozBin(String soubor, Seznam<DopravniProstredek> seznam) throws IOException, KolekceException {
        try {
            if (seznam.size() == 0) {
                System.err.println("Nelze uložit seznam do binárního souboru, protože v seznamu nejsou žádné položky.");
            } else {
                try {
                    Objects.requireNonNull(seznam);
                    ObjectOutputStream vystup = new ObjectOutputStream(new FileOutputStream(soubor));
                    vystup.reset();
                    vystup.writeInt(seznam.size());
                    Iterator<DopravniProstredek> it = seznam.iterator();
                    seznam.nastavPrvni();
                    while (it.hasNext()) {
                        vystup.writeObject(seznam.dejAktualni());
                        it.next();
                        try {
                            seznam.dalsi();
                        } catch (KolekceException e) {
                        }
                    }
                    vystup.close();
                } catch (IOException e) {
                    System.out.println("Seznam dopravních prostředků je prázdný, nelze zálohovat.");
                }
            }
        } catch (Exception e) {
            System.out.println("Seznam se nepovedlo zálohovat.");
        }
    }

    private static void ulozTxt(Seznam<DopravniProstredek> seznam, String soubor) throws IOException, KolekceException {
        try {
            ulozTextAkt(seznam, soubor);
        } catch (KolekceException e) {
            ulozTextNeakt(seznam, soubor);
        }
    }

    private static void ulozTextNeakt(Seznam<DopravniProstredek> seznam, String soubor) throws IOException, KolekceException {
        try {
            FileWriter writer = new FileWriter(new File(soubor));
            Iterator<DopravniProstredek> it = seznam.iterator();
            String vypis = "";
            seznam.nastavPrvni();
            while (it.hasNext()) {
                vypis = seznam.dejAktualni().toTextFile() + "\n";
                writer.write(vypis);
                it.next();
                try {
                    seznam.dalsi();
                } catch (Exception e) {
                }
            }
            System.out.println("Seznam dopravních prostředků byl úspěšně uložen do textového souboru.");
            writer.flush();
            writer.close();
            DopravniProstredek test = new Dodavka(DopravniProstredekTyp.TEST, "TEST1234", 1, 1, DodavkaTyp.NEZNAMY, 1);
            seznam.vlozPrvni(test);
            seznam.nastavPrvni();
            seznam.odeberAktualni();
        } catch (KolekceException ex) {
        }
    }

    private static void ulozTextAkt(Seznam<DopravniProstredek> seznam, String soubor) throws KolekceException, FileNotFoundException, IOException {
        FileWriter writer = new FileWriter(new File(soubor));
        Iterator<DopravniProstredek> it = seznam.iterator();
        String vypis = "";
        if (seznam.dejAktualni() != null) {
            DopravniProstredek aktualni = seznam.dejAktualni();
            try {
                seznam.nastavPrvni();
                while (it.hasNext()) {
                    vypis = seznam.dejAktualni().toTextFile() + "\n";
                    writer.write(vypis);
                    it.next();
                    try {
                        seznam.dalsi();
                    } catch (Exception e) {
                    }
                }
                System.out.println("Seznam dopravních prostředků byl úspěšně uložen do textového souboru.");
            } catch (Exception e) {
                System.out.println("Seznam dopravních prostředků se nepovedlo uložit.");
            }

            seznam.nastavPrvni();
            while (seznam.dejAktualni() != aktualni) {
                seznam.dalsi();
            }
        }
        writer.flush();
        writer.close();
    }

}
