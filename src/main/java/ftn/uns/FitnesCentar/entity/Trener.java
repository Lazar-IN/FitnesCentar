package ftn.uns.FitnesCentar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Trener implements Serializable {
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

    @OneToMany(mappedBy = "trener", fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    public Set<Trening> drziTreninge = new HashSet<Trening>();    //TREBA POPRAVITI

    //@OneToMany(mappedBy = "trener", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   //public Set<Integer> ocene = new HashSet<Integer>();

    public Trener() { } //TREBA

    /*
    public Trener(String koristinckoIme, String lozinka, String ime,
                  String prezime, String kontaktTelefon, String email,
                  LocalDate datumRodjenja, Boolean aktivan ,Set<Integer> ocene) {
        this.koristinckoIme = koristinckoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.kontaktTelefon = kontaktTelefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.uloga = ULOGA.TRENER;
        this.aktivan = aktivan;
        //this.ocene = ocene;
    }
    */

    public Trener(String koristinckoIme, String lozinka, String ime, String prezime,
                  String kontaktTelefon, String email, LocalDate datumRodjenja, Boolean aktivan) {
        this.koristinckoIme = koristinckoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.kontaktTelefon = kontaktTelefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.aktivan = aktivan;
        this.uloga = ULOGA.TRENER;
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

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Set<Trening> getDrziTreninge() {
        return drziTreninge;
    }

    public void setDrziTreninge(Set<Trening> drziTreninge) {
        this.drziTreninge = drziTreninge;
    }

    public boolean dodajTreningNaListu(Trening tt)
    {
        if(drziTreninge.add(tt))
        {
            System.out.println("Trening uspesno dodat");
            return true;
        }
        else
        {
            System.out.println("Trening nije dodat");
            return false;
        }
    }
    public boolean ukloniTreningSaListe(Trening tt)
    {
        if(drziTreninge.remove(tt))
        {
            System.out.println("Trening uspesno uklonjen");
            return true;
        }
        else
        {
            System.out.println("Trening nije uklonjen");
            return false;
        }
    }
    public void stampajListuTreninga()
    {
        System.out.println(drziTreninge);
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

    //FALI METODA/FUNKCIJA OCENI TRENING

}
