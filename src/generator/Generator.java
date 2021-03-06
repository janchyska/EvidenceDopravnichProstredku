package generator;

import java.util.Random;
import prostredky.*;

/**
 *
 * @author janch
 */
public class Generator {

    public static DopravniProstredek generujDopravniProstredek() {

        int moznost = (int) (Math.random() * 5) + 1;
        switch (moznost) {
            case 1:
                return generujDodavka();
            case 2:
                return generujMotocykl();
            case 3:
                return generujNakladniAutomobil();
            case 4:
                return generujOsobniAutomobil();
            case 5:
                return generujTraktor();
        }

        return null;

    }

    private static Dodavka generujDodavka() {
        return new Dodavka(DopravniProstredekTyp.DODAVKA, generujSPZ(), generujHmotnost(),
                generujVykon(), generujDodavkaTyp(), generujKapacitu());
    }

    private static Motocykl generujMotocykl() {
        return new Motocykl(DopravniProstredekTyp.MOTOCYKL, generujSPZ(), generujHmotnost(),
                generujVykon(), generujRidicskeOpravneni(), generujObjemMotoru());
    }

    private static NakladniAutomobil generujNakladniAutomobil() {
        return new NakladniAutomobil(DopravniProstredekTyp.NAKLADNI_AUTOMOBIL, generujSPZ(), generujHmotnost(),
                generujVykon(), generujNakladniAutomobilTyp(), generujMaxNosnost());
    }

    private static OsobniAutomobil generujOsobniAutomobil() {
        return new OsobniAutomobil(DopravniProstredekTyp.OSOBNI_AUTOMOBIL, generujSPZ(),
                generujHmotnost(), generujVykon(), generujBarvu(), generujPocetMist());
    }

    private static Traktor generujTraktor() {
        return new Traktor(DopravniProstredekTyp.TRAKTOR, generujSPZ(), generujHmotnost(),
                generujVykon(), generujZnackuTraktoru(), generujTah());
    }

    private static String generujSPZ() {
        String nabidka = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        while (stringBuilder.length() < 8) {
            int index = (int) (random.nextFloat() * nabidka.length());
            stringBuilder.append(nabidka.charAt(index));
        }
        String vysledek = stringBuilder.toString();
        return vysledek;
    }

    private static int generujHmotnost() {
        int hmotnost = (int) (Math.random() * 6500) + 150;
        return hmotnost;
    }

    private static int generujVykon() {
        int vykon = (int) (Math.random() * 600) + 1;
        return vykon;
    }

    private static int generujObjemMotoru() {
        int objemMotoru = (int) (Math.random() * 1800) + 125;
        return objemMotoru;
    }

    private static int generujKapacitu() {
        int kapacita = (int) (Math.random() * 120) + 10;
        return kapacita;
    }

    private static int generujTah() {
        int tah = (int) (Math.random() * 11000) + 1;
        return tah;
    }

    private static int generujPocetMist() {
        int pocetMist = (int) (Math.random() * 8) + 1;
        return pocetMist;
    }

    private static int generujMaxNosnost() {
        int maxNosnost = (int) (Math.random() * 24000) + 3500;
        return maxNosnost;
    }

    private static DodavkaTyp generujDodavkaTyp() {
        int moznost = (int) (Math.random() * 6) + 1;
        switch (moznost) {
            case 1:
                return DodavkaTyp.PICKUP;
            case 2:
                return DodavkaTyp.DVOJKABINA;
            case 3:
                return DodavkaTyp.VALNIK;
            case 4:
                return DodavkaTyp.SKLAPEC;
            case 5:
                return DodavkaTyp.MINIBUS;
            case 6:
                return DodavkaTyp.NEZNAMY;
        }
        return null;
    }

    private static RidicskeOpravneni generujRidicskeOpravneni() {
        int moznost = (int) (Math.random() * 5) + 1;
        switch (moznost) {
            case 1:
                return RidicskeOpravneni.AM;
            case 2:
                return RidicskeOpravneni.A1;
            case 3:
                return RidicskeOpravneni.A2;
            case 4:
                return RidicskeOpravneni.A;
            case 5:
                return RidicskeOpravneni.NEZNAME;
        }
        return null;
    }

    private static NakladniAutomobilTyp generujNakladniAutomobilTyp() {
        int moznost = (int) (Math.random() * 5) + 1;
        switch (moznost) {
            case 1:
                return NakladniAutomobilTyp.SKRIN;
            case 2:
                return NakladniAutomobilTyp.PLACHTA;
            case 3:
                return NakladniAutomobilTyp.VALNIK;
            case 4:
                return NakladniAutomobilTyp.SKLAPEC;
            case 5:
                return NakladniAutomobilTyp.CISTERNA;
        }
        return null;
    }

    private static Barva generujBarvu() {
        int moznost = (int) (Math.random() * 5) + 1;
        switch (moznost) {
            case 1:
                return Barva.CERNA;
            case 2:
                return Barva.SEDA;
            case 3:
                return Barva.BILA;
            case 4:
                return Barva.CERVENA;
            case 5:
                return Barva.MODRA;
            case 6:
                return Barva.JINA;
        }
        return null;
    }

    private static ZnackaTraktor generujZnackuTraktoru() {
        int moznost = (int) (Math.random() * 5) + 1;
        switch (moznost) {
            case 1:
                return ZnackaTraktor.JOHN_DEER;
            case 2:
                return ZnackaTraktor.ZETOR;
            case 3:
                return ZnackaTraktor.NEW_HOLLAND;
            case 4:
                return ZnackaTraktor.CLAAS;
            case 5:
                return ZnackaTraktor.JINY;
        }
        return null;
    }
}
