package gui;

import javafx.stage.Stage;
import prostredky.*;
import gui.*;

/**
 *
 * @author janch
 */
public class Editor extends Stage {

    public Editor(DopravniProstredek dopravniProstredek) {
        setTitle("Úprava dopravního prostředku");
        switch (dopravniProstredek.getTypNazev()) {
            case DODAVKA:
                DialogDodavka dialogD = new DialogDodavka(dopravniProstredek);
                break;
            case MOTOCYKL:
                DialogMotocykl dialogM = new DialogMotocykl(dopravniProstredek);
                break;
            case NAKLADNI_AUTOMOBIL:
                DialogNakladniAutomobil dialogNA = new DialogNakladniAutomobil(dopravniProstredek);
                break;
            case OSOBNI_AUTOMOBIL:
                DialogOsobniAutomobil dialogOA = new DialogOsobniAutomobil(dopravniProstredek);
                 break;
            case TRAKTOR:
                DialogTraktor dialogT = new DialogTraktor(dopravniProstredek);
                 break;
        }
    }

}
