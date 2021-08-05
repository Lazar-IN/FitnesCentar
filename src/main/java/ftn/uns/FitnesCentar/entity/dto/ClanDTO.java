package ftn.uns.FitnesCentar.entity.dto;

import ftn.uns.FitnesCentar.entity.ULOGA;

import java.time.LocalDate;

public class ClanDTO {
    private Long id;
    private String korisnickoIme;
    private String lozinka;
    private String ime;
    private String prezime;
    private String kontaktTelefon;
    private String email;
    private LocalDate datumRodjenja;
    private ULOGA uloga;
    private Boolean aktivan;

    //PRAZAN KONSTRUKTOR
    public ClanDTO() {}     //TREBA
    //KONSTRUKTOR
    public ClanDTO(Long id,String korisnickoIme, String lozinka,
                   String ime, String prezime, String kontaktTelefon,
                   String email, LocalDate datumRodjenja, ULOGA uloga,
                   Boolean aktivan) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.kontaktTelefon = kontaktTelefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.uloga = ULOGA.CLAN;
        this.aktivan = aktivan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
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

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public ULOGA getUloga() {
        return uloga;
    }

    public void setUloga(ULOGA uloga) {
        this.uloga = uloga;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }
}
