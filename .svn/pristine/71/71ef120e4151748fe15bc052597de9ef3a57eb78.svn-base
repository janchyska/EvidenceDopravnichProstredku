package prostredky;

/**
 *
 * @author janch
 */
public class Dodavka extends DopravniProstredek {

    private int kapacita;
    private DodavkaTyp typDodavky;

    public Dodavka(int id, DopravniProstredekTyp typNazev, String spz,
            int hmotnost, int vykon, DodavkaTyp typDodavky, int kapacita) {
        super(id, typNazev = DopravniProstredekTyp.DODAVKA, spz, vykon, hmotnost);
        this.kapacita = kapacita;
        this.typDodavky = typDodavky;
    }

    public Dodavka(DopravniProstredekTyp typNazev, String spz,
            int hmotnost, int vykon, DodavkaTyp typDodavky, int kapacita) {
        super(typNazev = DopravniProstredekTyp.DODAVKA, spz, vykon, hmotnost);
        this.kapacita = kapacita;
        this.typDodavky = typDodavky;
    }

    public int getKapacita() {
        return kapacita;
    }

    public void setKapacita(int kapacita) {
        this.kapacita = kapacita;
    }

    public DodavkaTyp getTypDodavky() {
        return typDodavky;
    }

    public DodavkaTyp setTypDodavky(DodavkaTyp typDodavky) {
        this.typDodavky = typDodavky;
        return this.typDodavky;
    }

    @Override
    public String toString() {
        return super.toString() + "typ=" + getTypDodavky() + ", kapacita=" + getKapacita();
    }
    @Override
    public String toTextFile(){
        return super.toTextFile() + getTypDodavky() + ", " + getKapacita();
    }
}
