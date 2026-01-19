package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Gost {
    private Long id;
    private String ime;
    private String prezime;
    private String email;
    private String telefon;
    private String brojPasosa;
    private List<Rezervacija> rezervacije = new ArrayList<>();

    public Gost() {
    }

    public Gost(Long id, String ime, String prezime, String email, String telefon, String brojPasosa, List<Rezervacija> rezervacije) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.telefon = telefon;
        this.brojPasosa = brojPasosa;
        this.rezervacije = rezervacije;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getBrojPasosa() {
        return brojPasosa;
    }

    public void setBrojPasosa(String brojPasosa) {
        this.brojPasosa = brojPasosa;
    }

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    @Override
    public String toString() {
        return "Gost{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", brojPasosa='" + brojPasosa + '\'' +
                ", rezervacije=" + rezervacije +
                '}';
    }
}
