package prostredky;

/**
 *
 * @author janch
 */
public class NakladniAutomobil extends DopravniProstredek {

    public int maxNosnost;
    private NakladniAutomobilTyp naTyp;

    public NakladniAutomobil(int id, DopravniProstredekTyp typNazev, String spz,
            int hmotnost, int vykon, NakladniAutomobilTyp naTyp, int maxNosnost) {
        super(id, typNazev = DopravniProstredekTyp.NAKLADNI_AUTOMOBIL, spz, vykon, hmotnost);
        this.maxNosnost = maxNosnost;
        this.naTyp = naTyp;
    }

    public NakladniAutomobil(DopravniProstredekTyp typNazev, String spz,
            int hmotnost, int vykon, NakladniAutomobilTyp naTyp, int maxNosnost) {
        super(typNazev = DopravniProstredekTyp.NAKLADNI_AUTOMOBIL, spz, vykon, hmotnost);
        this.maxNosnost = maxNosnost;
        this.naTyp = naTyp;
    }

    public int getMaxNosnost() {
        return maxNosnost;
    }

    public void setMaxNosnost(int maxNosnost) {
        this.maxNosnost = maxNosnost;
    }

    public NakladniAutomobilTyp getNaTyp() {
        return naTyp;
    }

    public NakladniAutomobilTyp setNaTyp(NakladniAutomobilTyp naTyp) {
        this.naTyp = naTyp;
        return this.naTyp;
    }

   @Override
    public String toString() {
        return super.toString() + "typ=" + getNaTyp()+ ", maximální nosnost=" + getMaxNosnost();
    }
    @Override
    public String toTextFile(){
    return super.toTextFile() + getNaTyp()+ ", " + getMaxNosnost();
    }

}
