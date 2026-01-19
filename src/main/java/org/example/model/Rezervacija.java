package org.example.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Rezervacija {

    private Long id;
    private String brojRezervacije;
    private Gost gost;
    private Soba soba;
    private LocalDate datumPrijave;
    private LocalDate datumOdjave;
    private LocalDate datumRezervacije;
    private double ukupnaCena;
    private StatusRezervacije status;
    private String napomena;
    private List<Usluga> dodatneUsluge = new ArrayList<>();

    public Rezervacija() {
    }

    public Rezervacija(Long id, String brojRezervacije, Gost gost, Soba soba, LocalDate datumPrijave, LocalDate datumOdjave, LocalDate datumRezervacije, double ukupnaCena, StatusRezervacije status, String napomena, List<Usluga> dodatneUsluge) {
        this.id = id;
        this.brojRezervacije = brojRezervacije;
        this.gost = gost;
        this.soba = soba;
        this.datumPrijave = datumPrijave;
        this.datumOdjave = datumOdjave;
        this.datumRezervacije = datumRezervacije;
        this.ukupnaCena = ukupnaCena;
        this.status = status;
        this.napomena = napomena;
        this.dodatneUsluge = dodatneUsluge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrojRezervacije() {
        return brojRezervacije;
    }

    public void setBrojRezervacije(String brojRezervacije) {
        this.brojRezervacije = brojRezervacije;
    }

    public Gost getGost() {
        return gost;
    }

    public void setGost(Gost gost) {
        this.gost = gost;
    }

    public Soba getSoba() {
        return soba;
    }

    public void setSoba(Soba soba) {
        this.soba = soba;
    }

    public LocalDate getDatumPrijave() {
        return datumPrijave;
    }

    public void setDatumPrijave(LocalDate datumPrijave) {
        this.datumPrijave = datumPrijave;
    }

    public LocalDate getDatumOdjave() {
        return datumOdjave;
    }

    public void setDatumOdjave(LocalDate datumOdjave) {
        this.datumOdjave = datumOdjave;
    }

    public LocalDate getDatumRezervacije() {
        return datumRezervacije;
    }

    public void setDatumRezervacije(LocalDate datumRezervacije) {
        this.datumRezervacije = datumRezervacije;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public StatusRezervacije getStatus() {
        return status;
    }

    public void setStatus(StatusRezervacije status) {
        this.status = status;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public List<Usluga> getDodatneUsluge() {
        return dodatneUsluge;
    }

    public void setDodatneUsluge(List<Usluga> dodatneUsluge) {
        this.dodatneUsluge = dodatneUsluge;
    }

    @Override
    public String toString() {
        return "Rezervacija{" +
                "id=" + id +
                ", brojRezervacije='" + brojRezervacije + '\'' +
                ", gost=" + gost +
                ", soba=" + soba +
                ", datumPrijave=" + datumPrijave +
                ", datumOdjave=" + datumOdjave +
                ", datumRezervacije=" + datumRezervacije +
                ", ukupnaCena=" + ukupnaCena +
                ", status=" + status +
                ", napomena='" + napomena + '\'' +
                ", dodatneUsluge=" + dodatneUsluge +
                '}';
    }

    public enum StatusRezervacije {
        POTVRDJENA("Potvrđena"),
        NA_CEKANJU("Na čekanju"),
        OTKAZANA("Otkazana"),
        ZAVRSENA("Završena"),
        NO_SHOW("Nije se pojavio");

        private final String displayName;

        StatusRezervacije(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
}
