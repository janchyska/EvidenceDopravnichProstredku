package prostredky;

/**
 *
 * @author janch
 */
public class OsobniAutomobil extends DopravniProstredek {

    private int pocetMist;
    private Barva barva;

    public OsobniAutomobil(int id, DopravniProstredekTyp typNazev, String spz,
            int hmotnost, int vykon, Barva barva, int pocetMist) {
        super(id, typNazev = DopravniProstredekTyp.OSOBNI_AUTOMOBIL, spz, vykon, hmotnost);
        this.pocetMist = pocetMist;
        this.barva = barva;
    }

    public OsobniAutomobil(DopravniProstredekTyp typNazev, String spz,
            int hmotnost, int vykon, Barva barva, int pocetMist) {
        super(typNazev = DopravniProstredekTyp.OSOBNI_AUTOMOBIL, spz, vykon, hmotnost);
        this.pocetMist = pocetMist;
        this.barva = barva;
    }

    public int getPocetMist() {
        return pocetMist;
    }

    public void setPocetMist(int pocetMist) {
        this.pocetMist = pocetMist;
    }

    public Barva getBarva() {
        return barva;
    }

    public Barva setBarva(Barva barva) {
        this.barva = barva;
        return this.barva;
    }

    @Override
    public String toString() {
        return super.toString() + "barva=" + getBarva()+ ", počet míst=" + getPocetMist();
    }
    @Override
    public String toTextFile(){
    return super.toTextFile() + getBarva() + ", " + getPocetMist();
    }

}
