package perzistence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;
import java.util.function.Function;
import kolekce.*;
import prostredky.*;
import java.util.Scanner;

/**
 *
 * @author janch
 */
public class PerzistenceNacti {
    
    public static <DopravniProstredek> Seznam<DopravniProstredek> obnovBin(String soubor, Seznam<DopravniProstredek> seznam) throws IOException {
        return nactiBin(soubor, seznam);
    }

    public static void nactiText(Seznam<DopravniProstredek> seznam, String soubor) throws FileNotFoundException {
        nactiTxt(seznam, soubor);
    }
    
    private static <DopravniProstredek> Seznam<DopravniProstredek> nactiBin(String soubor, Seznam<DopravniProstredek> seznam) throws IOException {
        try {
            Objects.requireNonNull(seznam);
            ObjectInputStream vstup = new ObjectInputStream(new FileInputStream(soubor));
            seznam.zrus();
            int pocet = vstup.readInt();
            for (int i = 0; i < pocet; i++) {
                seznam.vlozNaKonec((DopravniProstredek) vstup.readObject());
            }
            vstup.close();
        } catch (Exception e) {
        }
        return seznam;
    }
    
    private static void nactiTxt(Seznam<DopravniProstredek> seznam, String soubor) throws FileNotFoundException {
        try {
            File fi = new File(soubor);
            Scanner myReader = new Scanner(fi);
            if (!myReader.hasNextLine()) {
                System.out.println("Žádné položky nenačteny, protože soubor je prázdný.");
            }
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] items = data.split(",");
                String typ = items[0].trim();
                String spz = items[1].trim();
                int hmotnost = Integer.parseInt(items[3].trim());
                int vykon = Integer.parseInt(items[2].trim());
                switch (typ) {
                    case "do":
                        String typDodavkaT = items[4].trim();
                        DodavkaTyp typDodavka = DodavkaTyp.SKLAPEC;
                        switch (typDodavkaT) {
                            case "Pickup":
                                typDodavka = DodavkaTyp.PICKUP;
                                break;
                            case "Dvojkabina":
                                typDodavka = DodavkaTyp.DVOJKABINA;
                                break;
                            case "Valník":
                                typDodavka = DodavkaTyp.VALNIK;
                                break;
                            case "Sklápeč":
                                typDodavka = DodavkaTyp.SKLAPEC;
                                break;
                            case "Minibus":
                                typDodavka = DodavkaTyp.MINIBUS;
                                break;
                            case "Neznámý":
                                typDodavka = DodavkaTyp.NEZNAMY;
                                break;
                        }
                        int kapacita = Integer.parseInt(items[5].trim());
                        DopravniProstredek dopravniProstredekDo = new Dodavka(DopravniProstredekTyp.DODAVKA, spz, hmotnost, vykon, typDodavka, kapacita);
                        seznam.vlozNaKonec(dopravniProstredekDo);
                        break;
                    case "oa":
                        String typBarva = items[4].trim();
                        Barva barva = null;
                        switch (typBarva) {
                            case "černá":
                                barva = Barva.CERNA;
                                break;
                            case "šedá":
                                barva = Barva.SEDA;
                                break;
                            case "bílá":
                                barva = Barva.BILA;
                                break;
                            case "červená":
                                barva = Barva.CERVENA;
                                break;
                            case "modrá":
                                barva = Barva.MODRA;
                                break;
                            case "jiná":
                                barva = Barva.JINA;
                                break;
                        }
                        int pocetMist = Integer.parseInt(items[5].trim());
                        DopravniProstredek dopravniProstredekOA = new OsobniAutomobil(DopravniProstredekTyp.OSOBNI_AUTOMOBIL, spz, hmotnost, vykon, barva, pocetMist);
                        seznam.vlozNaKonec(dopravniProstredekOA);
                        break;
                    case "na":
                        String typNakladniAutomobil = items[4].trim();
                        NakladniAutomobilTyp typNA = NakladniAutomobilTyp.SKLAPEC;
                        switch (typNakladniAutomobil) {
                            case "skříň":
                                typNA = NakladniAutomobilTyp.SKRIN;
                                break;
                            case "plachta":
                                typNA = NakladniAutomobilTyp.PLACHTA;
                                break;
                            case "valník":
                                typNA = NakladniAutomobilTyp.VALNIK;
                                break;
                            case "sklápěč":
                                typNA = NakladniAutomobilTyp.SKLAPEC;
                                break;
                            case "cisterna":
                                typNA = NakladniAutomobilTyp.CISTERNA;
                                break;
                        }
                        int maxNosnost = Integer.parseInt(items[5].trim());
                        DopravniProstredek dopravniProstredekNA = new NakladniAutomobil(DopravniProstredekTyp.NAKLADNI_AUTOMOBIL, spz, hmotnost, vykon, typNA, maxNosnost);
                        seznam.vlozNaKonec(dopravniProstredekNA);
                        break;
                    case "mo":
                        String typRidicskehoOpravneni = items[4].trim();
                        RidicskeOpravneni typRO = null;
                        switch (typRidicskehoOpravneni) {
                            case "AM":
                                typRO = RidicskeOpravneni.AM;
                                break;
                            case "A1":
                                typRO = RidicskeOpravneni.A1;
                                break;
                            case "A2":
                                typRO = RidicskeOpravneni.A2;
                                break;
                            case "A":
                                typRO = RidicskeOpravneni.A;
                                break;
                            case "Neznámé":
                                typRO = RidicskeOpravneni.NEZNAME;
                                break;
                        }
                        int objemMotoru = Integer.parseInt(items[5].trim());
                        Motocykl dopravniProstredekMo = new Motocykl(DopravniProstredekTyp.MOTOCYKL, spz, hmotnost, vykon, typRO, objemMotoru);
                        seznam.vlozNaKonec(dopravniProstredekMo);
                        break;
                    case "tr":
                        String typZnackaTraktoru = items[4].trim();
                        ZnackaTraktor typZT = null;
                        switch (typZnackaTraktoru) {
                            case "John Deer":
                                typZT = ZnackaTraktor.JOHN_DEER;
                                break;
                            case "Zetor":
                                typZT = ZnackaTraktor.ZETOR;
                                break;
                            case "New Holland":
                                typZT = ZnackaTraktor.NEW_HOLLAND;
                                break;
                            case "Claas":
                                typZT = ZnackaTraktor.CLAAS;
                                break;
                            case "Jiný":
                                typZT = ZnackaTraktor.JINY;
                                break;
                        }
                        int tah = Integer.parseInt(items[5].trim());
                        DopravniProstredek dopravniProstredekTr = new Traktor(DopravniProstredekTyp.TRAKTOR, spz, hmotnost, vykon, typZT, tah);
                        seznam.vlozNaKonec(dopravniProstredekTr);
                        break;
                }
            }
            myReader.close();
            System.out.println("Seznam dopravních prostředků byl úspěšně uložen do binárního souboru.");
        } catch (Exception e) {
        }
    }
    
    public static void nactiText(Seznam<DopravniProstredek> seznam, Function<String, DopravniProstredek> mapper, String soubor) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(soubor));
        reader.lines().map(mapper).forEach(seznam::vlozNaKonec);
    }
}
