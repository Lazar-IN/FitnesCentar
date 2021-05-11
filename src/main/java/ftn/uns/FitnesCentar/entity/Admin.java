package ftn.uns.FitnesCentar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String koristinckoIme;

    @Column (nullable = false)
    private String lozinka;

    @Column (nullable = false)
    private String ime;

    @Column (nullable = false)
    private String prezime;

    @Column (name = "telefon")
    private String kontaktTelefon;

    @Column (nullable = false)
    private String email;

    @Column
    private LocalDate datumRodjenja;

    @Column
    private ULOGA uloga;

    @Column
    private Boolean aktivan;

    public Admin() { } //TREBA

    public Admin(String koristinckoIme, String lozinka, String ime,
                    String prezime, String kontaktTelefon,
                    String email, LocalDate datumRodjenja, Boolean aktivan) {
        this.koristinckoIme = koristinckoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.kontaktTelefon = kontaktTelefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.uloga = ULOGA.ADMIN;
        this.aktivan = aktivan;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getKoristinckoIme() {
        return koristinckoIme;
    }
    public void setKoristinckoIme(String koristinckoIme) {
        this.koristinckoIme = koristinckoIme;
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
    public Boolean isAktivan() {
        return aktivan;
    }
    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }
    public void stampaj()
    {
        System.out.println("------"+this.uloga+"------");
        System.out.println("Korisnicko ime: "+this.koristinckoIme);
        System.out.println("Ime: "+this.ime);
        System.out.println("Prezime: "+this.prezime);
        System.out.println("Tel: "+this.kontaktTelefon);
        System.out.println("Email: "+this.email);
        System.out.println("Datum rodjenja: "+this.datumRodjenja);
        //System.out.println("Uloga: "+this.uloga);
        System.out.print("Status: ");
        if(this.aktivan==true)
        {
            System.out.print("Aktivan");
        } else
        {
            System.out.print("Neaktivan");

        }
        System.out.println(" ");
        System.out.println(" ");
    }

    @Override
    public String toString() {
        return "Admin{" +
                "koristinckoIme='" + koristinckoIme + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", kontaktTelefon='" + kontaktTelefon + '\'' +
                ", email='" + email + '\'' +
                ", datumRodjenja=" + datumRodjenja +
                ", uloga=" + uloga +
                ", aktivan=" + aktivan +
                '}';
    }
}
