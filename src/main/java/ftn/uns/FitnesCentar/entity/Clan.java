package ftn.uns.FitnesCentar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Clan implements Serializable {
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

    @OneToMany(mappedBy = "clan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Trening> odradjeni = new HashSet<Trening>();

    @OneToMany(mappedBy = "clan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Trening> prijavljenZa = new HashSet<Trening>();

    @ManyToMany
    private Set<Termin> prijavljeniTermini = new HashSet<Termin>();

    public Clan() { } //TREBA

    public Clan(String koristinckoIme, String lozinka, String ime, String prezime,
                String kontaktTelefon, String email, LocalDate datumRodjenja,
                Boolean aktivan, Set<Trening> odradjeni, Set<Trening> prijavljenZa,
                Set<Termin> prijavljeniTermini) {
        this.koristinckoIme = koristinckoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.kontaktTelefon = kontaktTelefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.uloga = ULOGA.CLAN;
        this.aktivan = aktivan;
        this.odradjeni = odradjeni;
        this.prijavljenZa = prijavljenZa;
        this.prijavljeniTermini = prijavljeniTermini;
    }

    public Clan(String koristinckoIme, String lozinka, String ime, String prezime,
                String kontaktTelefon, String email, LocalDate datumRodjenja, Boolean aktivan) {
        this.koristinckoIme = koristinckoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.kontaktTelefon = kontaktTelefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.uloga = ULOGA.CLAN;
        this.aktivan = aktivan;
    }
    public void prijaviZa(Trening t){
        prijavljenZa.add(t);
    }

   public void odradio(Trening t) {
       prijavljenZa.remove(t);
       odradjeni.add(t);
   }
    //private ArrayList<Integer> ocene = new ArrayList<Integer>();

    //FALI LISTA OCENA
    //FALI METODA/FUNKCIJA OCENI TRENING
    ////////////////////////////////////////////////
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
        return "Clan{" +
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
