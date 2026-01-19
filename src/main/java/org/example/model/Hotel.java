package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private Long id;
    private String naziv;
    private String adresa;
    private String grad;
    private String telefon;
    private String email;
    private String website;
    private int brojZvezdica;
    private String opis;
    private List<Soba> sobe = new ArrayList<>();

    public Hotel() {
    }

    public Hotel(Long id, String naziv, String adresa, String grad, String telefon, String email, String website, int brojZvezdica, String opis, List<Soba> sobe) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.grad = grad;
        this.telefon = telefon;
        this.email = email;
        this.website = website;
        this.brojZvezdica = brojZvezdica;
        this.opis = opis;
        this.sobe = sobe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getBrojZvezdica() {
        return brojZvezdica;
    }

    public void setBrojZvezdica(int brojZvezdica) {
        this.brojZvezdica = brojZvezdica;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public List<Soba> getSobe() {
        return sobe;
    }

    public void setSobe(List<Soba> sobe) {
        this.sobe = sobe;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", adresa='" + adresa + '\'' +
                ", grad='" + grad + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", brojZvezdica=" + brojZvezdica +
                ", opis='" + opis + '\'' +
                ", sobe=" + sobe +
                '}';
    }
}
