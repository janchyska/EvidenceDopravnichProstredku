package command;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;
import kolekce.*;
import perzistence.*;
import prostredky.*;
import sprava.*;

/**
 *
 * @author janch
 */
public class CommandLineMain {

    Scanner vstup = new Scanner(System.in);
    private static String BIN_SOUBOR = "zaloha.bin";
    private static String TEXT_SOUBOR = "prostredky.csv";

    public static void main(String[] args) throws KolekceException, IOException {
        Ovladani<DopravniProstredek> spravce = new SpravaProstredku();
        spravce.vytvorSeznam(LinSeznam::new);
        moznosti(spravce);
        System.err.println("Konec programu");
    }

    public static void moznosti(Ovladani<DopravniProstredek> spravce) throws FileNotFoundException, IOException, KolekceException {
        Scanner vstup;
        String volba;
        do {
            System.out.print("Zadej příkaz: ");
            vstup = new Scanner(System.in);
            volba = vstup.nextLine();
            switch (volba) {
                case "help":
                case "h":
                    vypisNapovedu();
                    break;
                case "novy":
                case "no":
                    spravce.vlozPolozku(novyProstredek(spravce));
                    break;
                case "najdi":
                case "na":
                case "n":
                    DopravniProstredek dopravniProstredek = spravce.najdiPolozku(vytvorKlic());
                    if (dopravniProstredek != null) {
                        System.out.println(dopravniProstredek);
                    }
                    break;
                case "dej":
                    spravce.dejKopiiAktualniPolozky();
                    if (spravce.dejKopiiAktualniPolozky() == null) {
                        System.err.println("Není nastaven aktuální dopravní prostředek!");
                    } else {
                        System.out.println("Aktuálním prostředkem je: \n" + spravce.dejKopiiAktualniPolozky());
                    }
                    break;
                case "edituj":
                case "edit":
                    System.out.println("Aktuálním prostředkem je: " + spravce.dejKopiiAktualniPolozky());
                    spravce.editujAktualniPolozku(editor::edit);
                    break;
                case "vyjmi":
                    DopravniProstredek dp = spravce.vyjmiAktualniPolozku();
                    System.out.println("Byl odebrán aktuální dopravní prostředek: " + dp);
                    break;
                case "prvni":
                case "pr":
                    spravce.prejdiNaPrvniPolozku();

                    break;
                case "dalsi":
                case "da":
                    spravce.prejdiNaDalsiPolozku();
                    break;
                case "posledni":
                case "po":
                    spravce.prejdiNaPosledniPolozku();
                    break;
                case "pocet":
                    spravce.dejAktualniPocetPolozek();
                    System.out.println("Počet prostředků je " + spravce.dejAktualniPocetPolozek());
                    break;
                case "obnov":
                    spravce.nactiZeSouboru(BIN_SOUBOR);
                    break;
                case "zalohuj":
                    spravce.ulozDoSouboru(BIN_SOUBOR);
                    break;
                case "vypis":
                case "v":
                    vypis(spravce);
                    break;
                case "nactitext":
                case "nt":
                    spravce.nactiTextSoubor(TEXT_SOUBOR, perzistence.Mappers.mapperInput);
                    break;
                case "uloztext":
                case "ut":
                    if (spravce.dejAktualniPocetPolozek() == 0) {
                        System.err.println("Nelze uložit seznam doprávních prostředků do textového souboru, protože je prázdný.");
                    } else {
                        spravce.ulozTextSoubor(TEXT_SOUBOR, DopravniProstredek::toTextFile);
                    }
                    break;
                case "generuj":
                case "g":
                    System.out.print("Zadejte počet prostředků k vygenerování: ");
                    Scanner vstupPocetProstredku = new Scanner(System.in);
                    int pocetProstredku;
                    while (!vstupPocetProstredku.hasNextInt()) {
                        System.err.print("Chybný vstup\nZadejte počet prostředků k vygenerování: ");
                        vstupPocetProstredku = new Scanner(System.in);
                    }
                    pocetProstredku = vstupPocetProstredku.nextInt();
                    spravce.generujData(pocetProstredku);
                    break;
                case "zrus":
                    spravce.zrus();
                    break;
                case "exit":
                    return;
                default:
                    System.err.println("Neznámý příkaz!");
            }

        } while (true);
    }

    public static void vypisNapovedu() {
        System.out.println(" \n"
                + "help, h     - výpis příkazů \n"
                + "novy,no     - vytvoř novou instanci a vlož dopravní prostředek na konec seznamu \n"
                + "najdi,na,n  - najdi v seznamu dopravní prostředek podle státní poznávací značky \n"
                + "dej         - zobraz aktuální dopravní prostředek v seznamu \n"
                + "edituj,edit - edituj aktuální dopravní prostředek v seznamu \n"
                + "vyjmi       - vyjmi aktuální dopravní prostředek ze seznamu \n"
                + "prvni,pr    - nastav jako aktuální první dopravní prostředek v seznamu \n"
                + "dalsi,da    - přejdi na další dopravní prostředek \n"
                + "posledni,po - přejdi na posledni dopravní prostředek \n"
                + "pocet       - zobraz počet položek v seznamu \n"
                + "obnov       - obnov seznam dopravních prostředků z binárního souboru\n"
                + "zalohuj     - zalohuj seznam dopravních prostředků do binárního souboru \n"
                + "vypis       - zobraz seznam dopravních prostředků \n"
                + "nactitext,nt- načti seznam dopravních prostředků z textového souboru \n"
                + "uloztext,ut - ulož seznam dopravních prostředků do textového souboru \n"
                + "generuj,g   - generuj náhodně dopravní prostředky pro testování \n"
                + "zrus        - zruš všechny dopravní prostředky v seznamu \n"
                + "exit        - ukončení programu"
        );
    }

    private static DopravniProstredek novyProstredek(Ovladani<DopravniProstredek> spravce) {
        Scanner vstup = new Scanner(System.in);
        String msg = "1 - Dodávka, 2 - Motocykl, 3 - Nákladní automobil, "
                + "4 - Osobní automobil, 5 - Traktor: ";
        System.out.println("Zadejte číslo prostředku, který chcete vložit ");
        System.out.print(msg);
        DopravniProstredek dopravniP = null;
        while (!vstup.hasNextInt()) {
            System.err.println("Chybný vstup! Prosím zadejte hodnotu znova.");
            System.out.print(msg);
            vstup = new Scanner(System.in);
        }
        int cisloVstup = vstup.nextInt();
        while (cisloVstup < 1 || cisloVstup > 5) {
            System.err.println("Chybný vstup! Prosím zadejte hodnotu znova.");
            System.out.print(msg);
            vstup = new Scanner(System.in);
            cisloVstup = vstup.nextInt();
        }
        switch (cisloVstup) {
            case 1:
                dopravniP = novaDodavka();
                break;
            case 2:
                dopravniP = novyMotocykl();
                break;
            case 3:
                dopravniP = novyNakladniAutomobil();
                break;
            case 4:
                dopravniP = novyOsobniAutomobil();
                break;
            case 5:
                dopravniP = novyTraktor();
                break;
        }
        return dopravniP;
    }

    private static DopravniProstredek novaDodavka() {
        System.out.print("Zadejte SPZ dodávky: ");
        Scanner vstup = new Scanner(System.in);
        String spz = vstup.nextLine();
        while (spz.length() != 8) {
            System.err.println("Počet znaků musí být roven 8");
            System.out.print("Zadejte SPZ dodávky: ");
            vstup = new Scanner(System.in);
            spz = vstup.nextLine();
        }
        String spzUP = spz.toUpperCase();
        int vykon;
        System.out.print("Zadejte výkon dodávky: ");
        while (!vstup.hasNextInt()) {
            System.err.print("Chybně zadaná hodnota.\nZadejte výkon dodávky: ");
            vstup = new Scanner(System.in);
        }
        vykon = vstup.nextInt();
        int hmotnost;
        System.out.print("Zadejte hmotnost dodávky: ");
        while (!vstup.hasNextInt()) {
            System.err.print("Chybně zadaná hodnota.\nZadejte hmotnost dodávky: ");
            vstup = new Scanner(System.in);
        }
        hmotnost = vstup.nextInt();
        int kapacita;
        System.out.print("Zadejte kapacitu dodávky: ");
        while (!vstup.hasNextInt()) {
            System.err.print("Chybně zadaná hodnota.\nZadejte kapacitu dodávky: ");
            vstup = new Scanner(System.in);
        }
        kapacita = vstup.nextInt();
        DopravniProstredek dodavka = new Dodavka(DopravniProstredekTyp.DODAVKA, spzUP, vykon, hmotnost, typDodavka(), kapacita);
        return dodavka;
    }

    private static DodavkaTyp typDodavka() {
        String msgTypDodavkyZNabidky = "Prosím zvolte typ dodávky z nabídky \n"
                + "1 - Pickup, 2 - Dvojkabina, 3 - Valník, 4 - Sklápěč, 5 - Minibus, 6 - Neznámý typ";
        System.out.println(msgTypDodavkyZNabidky);
        System.out.print("Vaše volba: ");
        Scanner vstup = new Scanner(System.in);
        while (!vstup.hasNextInt()) {
            System.err.println("Chybně zadaná volba");
            System.out.println(msgTypDodavkyZNabidky);
            System.out.print("Vaše volba: ");
            vstup = new Scanner(System.in);
        }
        int volbaTypDodavka = vstup.nextInt();
        while (volbaTypDodavka < 1 || volbaTypDodavka > 6) {
            System.err.println("Chybně zadaná volba");
            System.out.println(msgTypDodavkyZNabidky);
            System.out.print("Vaše volba: ");
            vstup = new Scanner(System.in);
            volbaTypDodavka = vstup.nextInt();
        }
        DodavkaTyp volbaTyp = null;
        switch (volbaTypDodavka) {
            case 1:
                volbaTyp = DodavkaTyp.PICKUP;
                break;
            case 2:
                volbaTyp = DodavkaTyp.DVOJKABINA;
                break;
            case 3:
                volbaTyp = DodavkaTyp.VALNIK;
                break;
            case 4:
                volbaTyp = DodavkaTyp.SKLAPEC;
                break;
            case 5:
                volbaTyp = DodavkaTyp.MINIBUS;
                break;
            case 6:
                volbaTyp = DodavkaTyp.NEZNAMY;
                break;
            default:
                volbaTyp = DodavkaTyp.NEZNAMY;
        }
        return volbaTyp;
    }

    private static DopravniProstredek novyMotocykl() {
        Scanner vstup = new Scanner(System.in);
        System.out.print("Zadejte SPZ motocyklu: ");
        vstup = new Scanner(System.in);
        String spz = vstup.nextLine();
        while (spz.length() != 8) {
            System.err.println("Počet znaků musí být roven 8");
            System.out.print("Zadejte SPZ motocyklu:");
            Scanner vstupSpzOprava = new Scanner(System.in);
            spz = vstupSpzOprava.nextLine();
        }
        String spzUP = spz.toUpperCase();
        int vykon;
        System.out.print("Zadejte výkon motocyklu: ");
        while (!vstup.hasNextInt()) {
            System.err.print("Chybně zadaná hodnota.\nZadejte výkon motocyklu: ");
            vstup = new Scanner(System.in);
        }
        vykon = vstup.nextInt();
        int hmotnost;
        System.out.print("Zadejte hmotnost motocyklu: ");
        while (!vstup.hasNextInt()) {
            System.err.print("Chybně zadaná hodnota.\nZadejte hmotnost motocyklu:");
            vstup = new Scanner(System.in);
        }
        hmotnost = vstup.nextInt();
        int objemMotoru;
        System.out.print("Zadejte objem motoru: ");
        while (!vstup.hasNextInt()) {
            System.err.print("Chybně zadaná hodnota.\nZadejte objem motoru:");
            vstup = new Scanner(System.in);
        }
        objemMotoru = vstup.nextInt();
        DopravniProstredek motocykl = new Motocykl(DopravniProstredekTyp.MOTOCYKL, spzUP, vykon, hmotnost, typRidicskehoOpravneni(), objemMotoru);
        return motocykl;
    }

    private static RidicskeOpravneni typRidicskehoOpravneni() {
        String msgTypRidicskehoOpravneni = "Prosím zvolte typ řidičského oprávnění z nabídky: \n"
                + "1 - AM, 2 - A1, 3 - A2, 4 - A, 5 - Neznámé";
        System.out.println(msgTypRidicskehoOpravneni);
        System.out.print("Vaše volba: ");
        Scanner vstup = new Scanner(System.in);
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

    private static DopravniProstredek novyNakladniAutomobil() {
        System.out.print("Zadejte SPZ nákladního automobilu: ");
        Scanner vstup = new Scanner(System.in);
        String spz = vstup.nextLine();
        while (spz.length() != 8) {
            System.err.println("Počet znaků musí být roven 8");
            System.out.print("Zadejte SPZ nákladního automobilu: ");
            vstup = new Scanner(System.in);
            spz = vstup.nextLine();
        }
        String spzUP = spz.toUpperCase();
        int vykon;
        System.out.print("Zadejte výkon nákladního automobilu: ");
        while (!vstup.hasNextInt()) {
            System.err.print("Chybně zadaná hodnota.\nZadejte výkon nákladního automobilu: ");
            vstup = new Scanner(System.in);
        }
        vykon = vstup.nextInt();
        int hmotnost;
        System.out.print("Zadejte hmotnost nákladního automobilu: ");
        while (!vstup.hasNextInt()) {
            System.err.print("Chybně zadaná hodnota.\nZadejte hmnotnost nákladního automobilu: ");
            vstup = new Scanner(System.in);
        }
        hmotnost = vstup.nextInt();
        int maxNosnost;
        System.out.print("Zadejte maximální nosnost nákladního automobilu: ");
        while (!vstup.hasNextInt()) {
            System.err.print("Chybně zadaná hodnota.\nZadejte maximální nosnost nákladního automobilu: ");
            vstup = new Scanner(System.in);
        }
        maxNosnost = vstup.nextInt();
        DopravniProstredek nakladniAutomobil = new NakladniAutomobil(DopravniProstredekTyp.NAKLADNI_AUTOMOBIL, spzUP, vykon, hmotnost, typNakladnihoAutomobilu(), maxNosnost);
        return nakladniAutomobil;
    }

    private static NakladniAutomobilTyp typNakladnihoAutomobilu() {
        Scanner vstup = new Scanner(System.in);
        System.out.print("Prosím zvolte typ nákladního automobilu z nabídky:\n"
                + "1 - Skříň, 2 - Plachta, 3 - Valník, 4 - Sklápěč, 5 - Cisterna: ");
        int volbaTypuNakladnihoAutomobilu;
        while (!vstup.hasNextInt()) {
            System.err.println("Chybně zadaná volba");
            System.out.print("Prosím zvolte typ nákladního automobilu z nabídky:\n"
                    + "1 - Skříň, 2 - Plachta, 3 - Valník, 4 - Sklápěč, 5 - Cisterna: ");
            vstup = new Scanner(System.in);
        }
        volbaTypuNakladnihoAutomobilu = vstup.nextInt();
        while (volbaTypuNakladnihoAutomobilu < 1 || volbaTypuNakladnihoAutomobilu > 5) {
            System.err.println("Chybně zadaná volba");
            System.out.print("Prosím zvolte typ nákladního automobilu z nabídky:\n"
                    + "1 - Skříň, 2 - Plachta, 3 - Valník, 4 - Sklápěč, 5 - Cisterna: ");
            vstup = new Scanner(System.in);
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

    private static DopravniProstredek novyOsobniAutomobil() {
        Scanner vstup = new Scanner(System.in);
        System.out.print("Zadejte SPZ osobního automobilu: ");
        vstup = new Scanner(System.in);
        String spz = vstup.nextLine();
        while (spz.length() != 8) {
            System.err.println("Počet znaků musí být roven 8");
            System.out.print("Zadejte SPZ osobního automobilu: ");
            vstup = new Scanner(System.in);
            spz = vstup.nextLine();
        }
        String spzUP = spz.toUpperCase();
        int vykon;
        System.out.print("Zadejte výkon osobního automobilu: ");
        while (!vstup.hasNextInt()) {
            System.err.print("Chybně zadaná hodnota.\nZadejte výkon osobního automobilu: ");
            vstup = new Scanner(System.in);
        }
        vykon = vstup.nextInt();
        int hmotnost;
        System.out.print("Zadejte hmotnost osobního automobilu: ");
        while (!vstup.hasNextInt()) {
            System.err.print("Chybně zadaná hodnota.\nZadejte hmotnost osobního automobilu: ");
            vstup = new Scanner(System.in);
        }
        hmotnost = vstup.nextInt();
        int pocetMist;
        System.out.print("Zadejte počet sedadel osobního automobilu: ");
        while (!vstup.hasNextInt()) {
            System.err.print("Chybně zadaná hodnota.\nZadejte počet sedadel osobního automobilu: ");
            vstup = new Scanner(System.in);
        }
        pocetMist = vstup.nextInt();
        DopravniProstredek osobniAutomobil = new OsobniAutomobil(DopravniProstredekTyp.OSOBNI_AUTOMOBIL, spzUP, vykon, hmotnost, typBarva(), pocetMist);
        return osobniAutomobil;
    }

    private static Barva typBarva() {
        Scanner vstup = new Scanner(System.in);
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
            vstup = new Scanner(System.in);
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

    private static DopravniProstredek novyTraktor() {
        Scanner vstup = new Scanner(System.in);
        System.out.print("Zadejte SPZ traktoru: ");
        String spz = vstup.nextLine();
        while (spz.length() != 8) {
            System.err.println("Počet znaků musí být roven 8");
            System.out.print("Zadejte SPZ traktoru: ");
            Scanner vstupSpzOprava = new Scanner(System.in);
            spz = vstupSpzOprava.nextLine();
        }
        String spzUP = spz.toUpperCase();
        int vykon;
        System.out.print("Zadejte výkon traktoru: ");
        while (!vstup.hasNextInt()) {
            System.err.print("Chybně zadaná hodnota.\nZadejte výkon traktoru: ");
            vstup = new Scanner(System.in);
        }
        vykon = vstup.nextInt();
        int hmotnost;
        System.out.print("Zadejte hmotnost traktoru: ");
        while (!vstup.hasNextInt()) {
            System.err.print("Chybně zadaná hodnota.\nZadejte hmotnost traktoru: ");
            vstup = new Scanner(System.in);
        }
        hmotnost = vstup.nextInt();
        int tah;
        System.out.print("Zadejte tah traktoru: ");
        while (!vstup.hasNextInt()) {
            System.err.print("Chybně zadaná hodnota.\nZadejte tah traktoru: ");
            vstup = new Scanner(System.in);
        }
        tah = vstup.nextInt();
        DopravniProstredek traktor = new Traktor(DopravniProstredekTyp.TRAKTOR, spzUP, vykon, hmotnost, typZnackaTraktor(), tah);
        return traktor;
    }

    private static ZnackaTraktor typZnackaTraktor() {
        Scanner vstup = new Scanner(System.in);
        System.out.print("Prosím zvolte značku traktoru z nabídky\n"
                + "1 - John Deer, 2 - Zetor, 3 - New Holland, 4 - Claas, 5 -Jiný: ");
        int volbaZnackyTraktoru;
        while (!vstup.hasNextInt()) {
            System.err.println("Chybně zadaná volba");
            System.out.print("Prosím zvolte značku traktoru z nabídky\n"
                    + "1 - John Deer, 2 - Zetor, 3 - New Holland, 4 - Claas, 5 -Jiný: ");
            vstup = new Scanner(System.in);
        }
        volbaZnackyTraktoru = vstup.nextInt();
        while (volbaZnackyTraktoru < 1 || volbaZnackyTraktoru > 6) {
            System.err.println("Chybně zadaná volba!");
            System.out.print("Prosím zvolte značku traktoru z nabídky\n"
                    + "1 - John Deer, 2 - Zetor, 3 - New Holland, 4 - Claas, 5 -Jiný: ");
            vstup = new Scanner(System.in);
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

    private static void vypis(Ovladani<DopravniProstredek> spravce) {
        spravce.vypis(vypsat -> System.out.printf("%s\n", vypsat));
    }

    public static DopravniProstredekKlic vytvorKlic() {
        String spz = setSPZ("");
        return new DopravniProstredekKlic(spz);
    }

    private static String setSPZ(String spzO) {
        System.out.println("Zadejte SPZ dopravního prostředku:");
        if (spzO == "" && !spzO.isEmpty()) {
            System.out.print("Aktualní SPZ: " + spzO);
        }
        while (true) {
            Scanner vstup = new Scanner(System.in);
            String spz = vstup.nextLine().trim();
            if (spzO != "" & spz.isEmpty()) {
                return spzO;
            }
            if (spz.length() == 8) {
                return spz.toUpperCase();
            }

            System.err.println("Chybně zadaná SPZ!");
        }
    }

    
}
