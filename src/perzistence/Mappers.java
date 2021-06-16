package perzistence;

import java.util.function.Function;
import prostredky.Barva;
import prostredky.Dodavka;
import prostredky.DodavkaTyp;
import prostredky.DopravniProstredek;
import prostredky.DopravniProstredekTyp;
import prostredky.Motocykl;
import prostredky.NakladniAutomobil;
import prostredky.NakladniAutomobilTyp;
import prostredky.OsobniAutomobil;
import prostredky.RidicskeOpravneni;
import prostredky.Traktor;
import prostredky.ZnackaTraktor;

/**
 *
 * @author janch
 */
public class Mappers {

   public static Function<DopravniProstredek, String> mapperOutput = (prostredek) -> {
        switch (prostredek.getTypNazev()) {
            case OSOBNI_AUTOMOBIL:
                return String.format("oa, %s, %d, %d, %s, %d",
                        prostredek.getSpz(), prostredek.getHmotnost(),
                        prostredek.getVykon(),
                        ((OsobniAutomobil) prostredek).getBarva().barva(),
                        ((OsobniAutomobil) prostredek).getPocetMist()
                );
            case DODAVKA:
                return String.format("do, %s, %d, %d, %s, %d",
                        prostredek.getSpz(), prostredek.getHmotnost(),
                        prostredek.getVykon(),
                        ((Dodavka) prostredek).getTypDodavky().getTypDodavky(),
                        ((Dodavka) prostredek).getKapacita()
                );
            case NAKLADNI_AUTOMOBIL:
                return String.format("na, %s, %d, %d, %s, %d",
                        prostredek.getSpz(), prostredek.getHmotnost(),
                        prostredek.getVykon(),
                        ((NakladniAutomobil) prostredek).getNaTyp().getNaTyp(),
                        ((NakladniAutomobil) prostredek).getMaxNosnost()
                );
            case MOTOCYKL:
                return String.format("mo, %s, %d, %d, %s, %d",
                        prostredek.getSpz(), prostredek.getHmotnost(),
                        prostredek.getVykon(),
                        ((Motocykl) prostredek).getRidicskeOpravneni().getRidicskeOpravneni(),
                        ((Motocykl) prostredek).getObjemMotoru()
                );
            case TRAKTOR:
                return String.format("tr, %s, %d, %d, %s, %d",
                        prostredek.getSpz(), prostredek.getHmotnost(),
                        prostredek.getVykon(),
                        ((Traktor) prostredek).getZnackaTraktoru().getZnackaTraktoru(),
                        ((Traktor) prostredek).getTah()
                );
        }
        return null;
    };
    
    public static final Function<String, DopravniProstredek> mapperInput = (line) -> {
        DopravniProstredek prostredek = null;
        if (line.length() == 0) {
            return prostredek;
        }
        String[] items = line.split(",");
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
                prostredek = new Dodavka(DopravniProstredekTyp.DODAVKA, spz, hmotnost, vykon, typDodavka, kapacita);
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
                prostredek = new OsobniAutomobil(DopravniProstredekTyp.OSOBNI_AUTOMOBIL, spz, hmotnost, vykon, barva, pocetMist);
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
                prostredek = new NakladniAutomobil(DopravniProstredekTyp.NAKLADNI_AUTOMOBIL, spz, hmotnost, vykon, typNA, maxNosnost);
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
                prostredek = new Motocykl(DopravniProstredekTyp.MOTOCYKL, spz, hmotnost, vykon, typRO, objemMotoru);
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
                prostredek = new Traktor(DopravniProstredekTyp.TRAKTOR, spz, hmotnost, vykon, typZT, tah);
                break;
        }
        return prostredek;
    };
}
