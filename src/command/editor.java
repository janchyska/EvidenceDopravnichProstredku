package command;

import java.util.Objects;
import prostredky.DopravniProstredek;
import java.util.Scanner;
import prostredky.*;

/**
 *
 * @author janch
 */
public class editor {

    public static DopravniProstredek edit(DopravniProstredek aktualni) {
        DopravniProstredekTyp typ = aktualni.getTypNazev();
        Scanner vstup = new Scanner(System.in);
        if (typ == DopravniProstredekTyp.DODAVKA) {
            String puvodni = aktualni.toString();
            Dodavka dodavka = (Dodavka) aktualni;
            dodavka.setSpz(zadejSpz(vstup));
            dodavka.setVykon(zadejVykon(vstup));
            dodavka.setHmotnost(zadejHmotnost(vstup));
            dodavka.setTypDodavky(zadejDodavkaTyp(vstup));
            dodavka.setKapacita(zadejKapacitu(vstup));
            System.out.println("Původní dopravní prostředek byl: " + puvodni);
            System.out.println("Upravený dopravní prostředek je: " + dodavka);
        } else if (typ == DopravniProstredekTyp.MOTOCYKL) {
            String puvodni = aktualni.toString();
            Motocykl motocykl = (Motocykl) aktualni;
            motocykl.setSpz(zadejSpz(vstup));
            motocykl.setVykon(zadejVykon(vstup));
            motocykl.setHmotnost(zadejHmotnost(vstup));
            motocykl.setRidickeOpravneni(zadejRidicskeOpravneni(vstup));
            motocykl.setObjemMotoru(zadejObjem(vstup));
            System.out.println("Původní dopravní prostředek byl: " + puvodni);
            System.out.println("Upravený dopravní prostředek je: " + motocykl);
        } else if (typ == DopravniProstredekTyp.NAKLADNI_AUTOMOBIL) {
            String puvodni = aktualni.toString();
            NakladniAutomobil nakladniAutomobil = (NakladniAutomobil) aktualni;
            nakladniAutomobil.setSpz(zadejSpz(vstup));
            nakladniAutomobil.setVykon(zadejVykon(vstup));
            nakladniAutomobil.setHmotnost(zadejHmotnost(vstup));
            nakladniAutomobil.setNaTyp(zadejTypNakladnihoAutomobilu(vstup));
            nakladniAutomobil.setMaxNosnost(zadejMaxNosnost(vstup));
            System.out.println("Původní dopravní prostředek byl: " + puvodni);
            System.out.println("Upravený dopravní prostředek je: " + nakladniAutomobil);
        } else if (typ == DopravniProstredekTyp.OSOBNI_AUTOMOBIL) {
            String puvodni = aktualni.toString();
            OsobniAutomobil osobniAutomobil = (OsobniAutomobil) aktualni;
            osobniAutomobil.setSpz(zadejSpz(vstup));
            osobniAutomobil.setVykon(zadejVykon(vstup));
            osobniAutomobil.setHmotnost(zadejHmotnost(vstup));
            osobniAutomobil.setBarva(zadejBarvu(vstup));
            osobniAutomobil.setPocetMist(zadejPocetMist(vstup));
            System.out.println("Původní dopravní prostředek byl: " + puvodni);
            System.out.println("Upravený dopravní prostředek je: " + osobniAutomobil);
        } else if (typ == DopravniProstredekTyp.TRAKTOR) {
            String puvodni = aktualni.toString();
            Traktor traktor = (Traktor) aktualni;
            traktor.setSpz(zadejSpz(vstup));
            traktor.setVykon(zadejVykon(vstup));
            traktor.setHmotnost(zadejHmotnost(vstup));
            traktor.setZnackaTraktoru(zadejZnackuTraktoru(vstup));
            traktor.setTah(zadejTah(vstup));
            System.out.println("Původní dopravní prostředek byl: " + puvodni);
            System.out.println("Upravený dopravní prostředek je: " + traktor);
        }
        return null;
    }

    public static String zadejSpz(Scanner vstup) {
        System.out.print("Zadejte novou SPZ vozidla: ");
        vstup = new Scanner(System.in);
        String spzV = vstup.nextLine();
        while (spzV.length() != 8) {
            System.out.println("Počet znaků musí být roven 8");
            System.out.print("Zadejte novou SPZ vozidla: ");
            vstup = new Scanner(System.in);
            spzV = vstup.nextLine();
        }
        String spz = spzV.toUpperCase();
        return spz;
    }

    public static int zadejVykon(Scanner vstup) {
        System.out.print("Zadejte nový výkon vozidla: ");
        vstup = new Scanner(System.in);
        while (!vstup.hasNextInt()) {
            System.out.print("Chybně zadaná hodnota.\nZadejte nový výkon vozidla: ");
            vstup = new Scanner(System.in);
        }
        int vykon = vstup.nextInt();
        return vykon;
    }

    public static int zadejHmotnost(Scanner vstup) {
        System.out.print("Zadejte novou hmotnost vozidla:");
        vstup = new Scanner(System.in);
        while (!vstup.hasNextInt()) {
            System.out.print("Chybně zadaná hodnota.\nZadejte novou hmotnost vozidla: ");
            vstup = new Scanner(System.in);
        }
        int hmotnost = vstup.nextInt();
        return hmotnost;
    }

    public static int zadejKapacitu(Scanner vstup) {
        System.out.print("Zadejte novou kapacitu vozidla: ");
        vstup = new Scanner(System.in);
        while (!vstup.hasNextInt()) {
            System.out.print("Chybně zadaná hodnota.\nZadejte novou kapacitu dodávky: ");
            vstup = new Scanner(System.in);
        }
        int kapacita = vstup.nextInt();
        return kapacita;
    }

    public static DodavkaTyp zadejDodavkaTyp(Scanner vstup) {
        System.out.println("Prosím zvolte nový typ dodávky z nabídky\n"
                + "1 - Pickup, 2 - Dvojkabina, 3 - Valník, 4 - Sklápěč, 5 - Minibus, 6 - Neznámý typ");
        System.out.print("Vaše volba: ");
        int vstupni;
        while (!vstup.hasNextInt()) {
            System.err.println("Chybně zadaná volba");
            System.out.println("Prosím zvolte nový typ dodávky z nabídky\n"
                    + "1 - Pickup, 2 - Dvojkabina, 3 - Valník, 4 - Sklápěč, 5 - Minibus, 6 - Neznámý typ");
            System.out.print("Vaše volba: ");
            vstup = new Scanner(System.in);
        }
        vstupni = vstup.nextInt();
        while (vstupni < 1 || vstupni > 6) {
            System.err.println("Chybně zadaná volba");
            System.out.println("Prosím zvolte nový typ dodávky z nabídky\n"
                    + "1 - Pickup, 2 - Dvojkabina, 3 - Valník, 4 - Sklápěč, 5 - Minibus, 6 - Neznámý typ");
            System.out.print("Vaše volba: ");
            vstup = new Scanner(System.in);
            vstupni = vstup.nextInt();
        }
        DodavkaTyp dodavkaTyp;
        switch (vstupni) {
            case 1:
                dodavkaTyp = DodavkaTyp.PICKUP;
                break;
            case 2:
                dodavkaTyp = DodavkaTyp.DVOJKABINA;
                break;
            case 3:
                dodavkaTyp = DodavkaTyp.VALNIK;
                break;
            case 4:
                dodavkaTyp = DodavkaTyp.SKLAPEC;
                break;
            case 5:
                dodavkaTyp = DodavkaTyp.MINIBUS;
                break;
            case 6:
                dodavkaTyp = DodavkaTyp.NEZNAMY;
                break;
            default:
                dodavkaTyp = DodavkaTyp.NEZNAMY;
        }
        return dodavkaTyp;
    }

    public static RidicskeOpravneni zadejRidicskeOpravneni(Scanner vstup) {
        String msgTypRidicskehoOpravneni = "Prosím zvolte typ řidičského oprávnění z nabídky: \n"
                + "1 - AM, 2 - A1, 3 - A2, 4 - A, 5 - Neznámé";
        System.out.println(msgTypRidicskehoOpravneni);
        System.out.print("Vaše volba: ");
        while (!vstup.hasNextInt()) {
            System.err.println("Chybně zadaná volba!");
            System.out.println(msgTypRidicskehoOpravneni);
            System.out.print("Vaše volba: ");
            vstup = new Scanner(System.in);
        }
        int volbaTypuRidicskehoOpravneni = vstup.nextInt();
        while (volbaTypuRidicskehoOpravneni < 1 || volbaTypuRidicskehoOpravneni > 5) {
            System.err.println("Chybně zadaná volba!");
            System.out.println(msgTypRidicskehoOpravneni);
            System.out.print("Vaše volba: ");
            vstup = new Scanner(System.in);
            volbaTypuRidicskehoOpravneni = vstup.nextInt();
        }
        RidicskeOpravneni volbaTypRidicskehoOpravneni = null;
        switch (volbaTypuRidicskehoOpravneni) {
            case 1:
                volbaTypRidicskehoOpravneni = RidicskeOpravneni.AM;
                break;
            case 2:
                volbaTypRidicskehoOpravneni = RidicskeOpravneni.A1;
                break;
            case 3:
                volbaTypRidicskehoOpravneni = RidicskeOpravneni.A2;
                break;
            case 4:
                volbaTypRidicskehoOpravneni = RidicskeOpravneni.A;
                break;
            default:
                volbaTypRidicskehoOpravneni = RidicskeOpravneni.NEZNAME;
        }
        return volbaTypRidicskehoOpravneni;
    }

    public static int zadejObjem(Scanner vstup) {
        System.out.print("Zadejte objem motoru: ");
        vstup = new Scanner(System.in);
        while (!vstup.hasNextInt()) {
            System.err.print("Chybně zadaná hodnota.\nZadejte objem motoru:");
            vstup = new Scanner(System.in);
        }
        int objemMotoru = vstup.nextInt();
        return objemMotoru;
    }

    public static int zadejMaxNosnost(Scanner vstup) {
        System.out.print("Zadejte maximální nosnost: ");
        vstup = new Scanner(System.in);
        while (!vstup.hasNextInt()) {
            System.err.print("Chybně zadaná hodnota.\nZadejte maximální nosnost:");
            vstup = new Scanner(System.in);
        }
        int maximalniNosnost = vstup.nextInt();
        return maximalniNosnost;
    }

    public static NakladniAutomobilTyp zadejTypNakladnihoAutomobilu(Scanner vstup) {
        System.out.print("Prosím zvolte typ nákladního automobilu z nabídky:\n"
                + "1 - Skříň, 2 - Plachta, 3 - Valník, 4 - Sklápěč, 5 - Cisterna: ");
        while (!vstup.hasNextInt()) {
            System.err.println("Chybně zadaná volba");
            System.out.print("Prosím zvolte typ nákladního automobilu z nabídky:\n"
                    + "1 - Skříň, 2 - Plachta, 3 - Valník, 4 - Sklápěč, 5 - Cisterna: ");
            vstup = new Scanner(System.in);
        }
        int volbaTypuNakladnihoAutomobilu = vstup.nextInt();
        while (volbaTypuNakladnihoAutomobilu < 1 || volbaTypuNakladnihoAutomobilu > 5) {
            System.err.println("Chybně zadaná volba");
            System.out.print("Prosím zvolte typ nákladního automobilu z nabídky:\n"
                    + "1 - Skříň, 2 - Plachta, 3 - Valník, 4 - Sklápěč, 5 - Cisterna: ");
            volbaTypuNakladnihoAutomobilu = vstup.nextInt();
        }
        NakladniAutomobilTyp volbaTypNakladniAutomobil = null;
        switch (volbaTypuNakladnihoAutomobilu) {
            case 1:
                volbaTypNakladniAutomobil = NakladniAutomobilTyp.SKRIN;
                break;
            case 2:
                volbaTypNakladniAutomobil = NakladniAutomobilTyp.PLACHTA;
                break;
            case 3:
                volbaTypNakladniAutomobil = NakladniAutomobilTyp.VALNIK;
                break;
            case 4:
                volbaTypNakladniAutomobil = NakladniAutomobilTyp.SKLAPEC;
                break;
            case 5:
                volbaTypNakladniAutomobil = NakladniAutomobilTyp.CISTERNA;
                break;
            default:
                volbaTypNakladniAutomobil = NakladniAutomobilTyp.SKRIN;
        }
        return volbaTypNakladniAutomobil;
    }

    public static int zadejPocetMist(Scanner vstup) {
        System.out.print("Zadejte počet míst: ");
        vstup = new Scanner(System.in);
        while (!vstup.hasNextInt()) {
            System.err.print("Chybně zadaná hodnota.\nZadejte počet míst: ");
            vstup = new Scanner(System.in);
        }
        int pocetMist = vstup.nextInt();
        return pocetMist;
    }

    public static Barva zadejBarvu(Scanner vstup) {
        System.out.print("Prosím zvolte barvu osobního automobilu z nabídky\n"
                + "1 - černá, 2 - šedá, 3 - bílá, 4 - červená, 5 - modrá, 6 - jiná: ");
        while (!vstup.hasNextInt()) {
            System.err.println("Chybně zadaná volba");
            System.out.print("Prosím zvolte barvu osobního automobilu z nabídky\n"
                    + "1 - černá, 2 - šedá, 3 - bílá, 4 - červená, 5 - modrá, 6 - jiná: ");
            vstup = new Scanner(System.in);
        }
        int volbaTypuBarvy = vstup.nextInt();
        while (volbaTypuBarvy < 1 || volbaTypuBarvy > 6) {
            System.err.println("Chybně zadaná volba!");
            System.out.print("Prosím zvolte barvu osobního automobilu z nabídky\n"
                    + "1 - černá, 2 - šedá, 3 - bílá, 4 - červená, 5 - modrá, 6 - jiná: ");
            volbaTypuBarvy = vstup.nextInt();
        }
        Barva volbaTypBarva = null;
        switch (volbaTypuBarvy) {
            case 1:
                volbaTypBarva = Barva.CERNA;
                break;
            case 2:
                volbaTypBarva = Barva.SEDA;
                break;
            case 3:
                volbaTypBarva = Barva.BILA;
                break;
            case 4:
                volbaTypBarva = Barva.CERVENA;
                break;
            case 5:
                volbaTypBarva = Barva.MODRA;
                break;
            case 6:
                volbaTypBarva = Barva.JINA;
                break;
            default:
                volbaTypBarva = Barva.JINA;
        }
        return volbaTypBarva;
    }

    public static int zadejTah(Scanner vstup) {
        System.out.print("Zadejte tah: ");
        vstup = new Scanner(System.in);
        while (!vstup.hasNextInt()) {
            System.err.print("Chybně zadaná hodnota.\nZadejte tah: ");
            vstup = new Scanner(System.in);
        }
        int tah = vstup.nextInt();
        return tah;
    }

    public static ZnackaTraktor zadejZnackuTraktoru(Scanner vstup) {
        System.out.print("Prosím zvolte značku traktoru z nabídky\n"
                + "1 - John Deer, 2 - Zetor, 3 - New Holland, 4 - Claas, 5 -Jiný: ");
        while (!vstup.hasNextInt()) {
            System.err.println("Chybně zadaná volba");
            System.out.print("Prosím zvolte značku traktoru z nabídky\n"
                    + "1 - John Deer, 2 - Zetor, 3 - New Holland, 4 - Claas, 5 -Jiný: ");
            vstup = new Scanner(System.in);
        }
        int volbaZnackyTraktoru = vstup.nextInt();
        while (volbaZnackyTraktoru < 1 || volbaZnackyTraktoru > 6) {
            System.err.println("Chybně zadaná volba!");
            System.out.print("Prosím zvolte značku traktoru z nabídky\n"
                    + "1 - John Deer, 2 - Zetor, 3 - New Holland, 4 - Claas, 5 -Jiný: ");
            volbaZnackyTraktoru = vstup.nextInt();
        }
        ZnackaTraktor volbaZnackaTraktor = null;
        switch (volbaZnackyTraktoru) {
            case 1:
                volbaZnackaTraktor = ZnackaTraktor.JOHN_DEER;
                break;
            case 2:
                volbaZnackaTraktor = ZnackaTraktor.ZETOR;
                break;
            case 3:
                volbaZnackaTraktor = ZnackaTraktor.NEW_HOLLAND;
                break;
            case 4:
                volbaZnackaTraktor = ZnackaTraktor.CLAAS;
                break;
            case 5:
                volbaZnackaTraktor = ZnackaTraktor.JINY;
                break;
            default:
                volbaZnackaTraktor = ZnackaTraktor.JINY;
        }
        return volbaZnackaTraktor;
    }
}
