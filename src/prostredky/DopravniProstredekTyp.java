package prostredky;

/**
 *
 * @author janch
 */
public enum DopravniProstredekTyp {
    OSOBNI_AUTOMOBIL("oa"),
    DODAVKA("do"),
    NAKLADNI_AUTOMOBIL("na"),
    TRAKTOR("tr"),
    MOTOCYKL("mo"),
    TEST("test"),
    KLIC("klíč"),
    NON_FILTER("nefiltruj");

    private final String typNazev;

    private DopravniProstredekTyp(String typNazev) {
        this.typNazev = typNazev;
    }

    public String typNazev() {
        return this.typNazev;
    }

    public String getTypNazev() {
        return typNazev;
    }

    public static Enum[] getProstredky() {
        Enum[] vycet = {OSOBNI_AUTOMOBIL, NAKLADNI_AUTOMOBIL, DODAVKA, MOTOCYKL, TRAKTOR};
        return vycet;
    }

    public static Enum[] getProstredkyFilter() {
        Enum[] vycet = {OSOBNI_AUTOMOBIL, NAKLADNI_AUTOMOBIL, DODAVKA, MOTOCYKL, TRAKTOR, NON_FILTER};
        return vycet;
    }

    @Override
    public String toString() {
        return typNazev;
    }

}
