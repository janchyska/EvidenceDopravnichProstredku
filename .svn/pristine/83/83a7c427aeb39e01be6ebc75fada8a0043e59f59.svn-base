package prostredky;

/**
 *
 * @author janch
 */
public class Motocykl extends DopravniProstredek {

    private int objemMotoru;
    private RidicskeOpravneni ridicskeOpravneni;

    public Motocykl(int id, DopravniProstredekTyp typNazev, String spz,
            int hmotnost, int vykon, RidicskeOpravneni ridicskeOpravneni, int objemMotoru) {
        super(id, typNazev = DopravniProstredekTyp.MOTOCYKL, spz, vykon, hmotnost);
        this.ridicskeOpravneni = ridicskeOpravneni;
        this.objemMotoru = objemMotoru;
    }

    public Motocykl(DopravniProstredekTyp typNazev, String spz,
            int hmotnost, int vykon, RidicskeOpravneni ridicskeOpravneni, int objemMotoru) {
        super(typNazev = DopravniProstredekTyp.MOTOCYKL, spz, vykon, hmotnost);
        this.ridicskeOpravneni = ridicskeOpravneni;
        this.objemMotoru = objemMotoru;
    }

    public int getObjemMotoru() {
        return objemMotoru;
    }

    public void setObjemMotoru(int objemMotoru) {
        this.objemMotoru = objemMotoru;
    }

    public RidicskeOpravneni getRidicskeOpravneni() {
        return ridicskeOpravneni;
    }

    public RidicskeOpravneni setRidickeOpravneni(RidicskeOpravneni ridicskeOpravneni) {
        this.ridicskeOpravneni = ridicskeOpravneni;
        return this.ridicskeOpravneni;
    }

    @Override
    public String toString() {
        return super.toString() + "řidičské oprávnění=" + getRidicskeOpravneni() + ", objem motoru=" + getObjemMotoru();
    }
    @Override
    public String toTextFile(){
    return super.toTextFile() + getRidicskeOpravneni() + ", " + getObjemMotoru();
    }


}
