package prostredky;

/**
 *
 * @author janch
 */
public class Traktor extends DopravniProstredek {

    private int tah;
    private ZnackaTraktor znackaTraktoru;

    public Traktor(int id, DopravniProstredekTyp typNazev, String spz,
            int hmotnost, int vykon, ZnackaTraktor znackaTraktoru, int tah) {
        super(id, typNazev = DopravniProstredekTyp.TRAKTOR, spz, vykon, hmotnost);
        this.tah = tah;
        this.znackaTraktoru = znackaTraktoru;
    }

    public Traktor(DopravniProstredekTyp typNazev, String spz,
            int hmotnost, int vykon, ZnackaTraktor znackaTraktoru, int tah) {
        super(typNazev = DopravniProstredekTyp.TRAKTOR, spz, vykon, hmotnost);
        this.tah = tah;
        this.znackaTraktoru = znackaTraktoru;
    }

    public int getTah() {
        return tah;
    }

    public void setTah(int tah) {
        this.tah = tah;
    }

    public ZnackaTraktor getZnackaTraktoru() {
        return znackaTraktoru;
    }

    public ZnackaTraktor setZnackaTraktoru(ZnackaTraktor znackaTraktoru) {
        this.znackaTraktoru = znackaTraktoru;
        return this.znackaTraktoru;
    }

    @Override
    public String toString() {
        return super.toString() + "značka traktoru=" + getZnackaTraktoru()+ ", tah=" + getTah();
    }
    @Override
    public String toTextFile(){
    return super.toTextFile() + getZnackaTraktoru()+ ", " + getTah();
    }

}
