package org.example.model;

public class Soba {

    private Long id;
    private String brojSobe;
    private TipSobe tip;
    private int sprat;
    private double cenaPoNoci;
    private boolean dostupna = true;
    private int maxOsoba;
    private boolean terasa;
    private boolean klima;
    private boolean miniBar;
    private Hotel hotel;

    public Soba() {
    }

    public Soba(Long id, String brojSobe, TipSobe tip, int sprat, double cenaPoNoci, boolean dostupna, int maxOsoba, boolean terasa, boolean klima, boolean miniBar, Hotel hotel) {
        this.id = id;
        this.brojSobe = brojSobe;
        this.tip = tip;
        this.sprat = sprat;
        this.cenaPoNoci = cenaPoNoci;
        this.dostupna = dostupna;
        this.maxOsoba = maxOsoba;
        this.terasa = terasa;
        this.klima = klima;
        this.miniBar = miniBar;
        this.hotel = hotel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrojSobe() {
        return brojSobe;
    }

    public void setBrojSobe(String brojSobe) {
        this.brojSobe = brojSobe;
    }

    public TipSobe getTip() {
        return tip;
    }

    public void setTip(TipSobe tip) {
        this.tip = tip;
    }

    public int getSprat() {
        return sprat;
    }

    public void setSprat(int sprat) {
        this.sprat = sprat;
    }

    public double getCenaPoNoci() {
        return cenaPoNoci;
    }

    public void setCenaPoNoci(double cenaPoNoci) {
        this.cenaPoNoci = cenaPoNoci;
    }

    public boolean isDostupna() {
        return dostupna;
    }

    public void setDostupna(boolean dostupna) {
        this.dostupna = dostupna;
    }

    public int getMaxOsoba() {
        return maxOsoba;
    }

    public void setMaxOsoba(int maxOsoba) {
        this.maxOsoba = maxOsoba;
    }

    public boolean isTerasa() {
        return terasa;
    }

    public void setTerasa(boolean terasa) {
        this.terasa = terasa;
    }

    public boolean isKlima() {
        return klima;
    }

    public void setKlima(boolean klima) {
        this.klima = klima;
    }

    public boolean isMiniBar() {
        return miniBar;
    }

    public void setMiniBar(boolean miniBar) {
        this.miniBar = miniBar;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Soba{" +
                "id=" + id +
                ", brojSobe='" + brojSobe + '\'' +
                ", tip=" + tip +
                ", sprat=" + sprat +
                ", cenaPoNoci=" + cenaPoNoci +
                ", dostupna=" + dostupna +
                ", maxOsoba=" + maxOsoba +
                ", terasa=" + terasa +
                ", klima=" + klima +
                ", miniBar=" + miniBar +
                ", hotel=" + hotel +
                '}';
    }

    public enum TipSobe {
        SINGLE("Jednokrevetna"),
        DOUBLE("Dvokrevetna"),
        TWIN("Dva single kreveta"),
        SUITE("Apartman"),
        FAMILY("Porodična"),
        DELUXE("Deluxe");

        private final String displayName;

        TipSobe(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

}
