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
    private  Long id;

    @Column(nullable = false,unique = true, name = "user")
    private String koristinckoIme;

    @Column(nullable = false, name = "lozinka")
    private String lozinka;

    @Column(nullable = false, name = "ime")
    private String ime;

    @Column(nullable = false, name = "prezime")
    private String prezime;

    @Column(nullable = false, name = "telefon")
    private String kontaktTelefon;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(name="datum_Rodjenja")
    private LocalDate datumRodjenja;

    @Column(name = "uloga")
    private ULOGA uloga;

    @Column(name = "aktivan")
    private Boolean aktivan;

    @ManyToMany//PROVERITI
    @JoinTable(name = "odradjeni_treninzi",
            joinColumns = @JoinColumn(name = "clan_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id",referencedColumnName = "id"))
    private Set<Trening> odradjeni = new HashSet<Trening>();

    @ManyToMany//PROVERITI
    @JoinTable(name = "prijavljen_za_treninge",
            joinColumns = @JoinColumn(name = "clan_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id",referencedColumnName = "id"))
    private Set<Trening> prijavljenZa = new HashSet<Trening>();
    //PROVERITI
    @OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Ocena> listaOcena = new HashSet<Ocena>();

    public Clan() { } //TREBA
    //KONSTRUKTOR SA LISTAMA
    public Clan(String koristinckoIme, String lozinka, String ime, String prezime,
                String kontaktTelefon, String email, LocalDate datumRodjenja,
                Boolean aktivan, Set<Trening> odradjeni, Set<Trening> prijavljenZa,Set<Ocena> listaOcena) {
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
        this.listaOcena = listaOcena;
    }
    //KONSTRUKTOR BEZ LISTI
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

    public Set<Trening> getOdradjeni() {
        return odradjeni;
    }

    public void setOdradjeni(Set<Trening> odradjeni) {
        this.odradjeni = odradjeni;
    }

    public Set<Trening> getPrijavljenZa() {
        return prijavljenZa;
    }

    public void setPrijavljenZa(Set<Trening> prijavljenZa) {
        this.prijavljenZa = prijavljenZa;
    }

    public Set<Ocena> getListaOcena() {
        return listaOcena;
    }

    public void setListaOcena(Set<Ocena> listaOcena) {
        this.listaOcena = listaOcena;
    }

    public void prijaviZa(Trening t){
        prijavljenZa.add(t);
    }

    public void odradio(Trening t) {
        prijavljenZa.remove(t);
        odradjeni.add(t);
    }

    ////////////////////////////////////////////////
    public void oceni(Termin termin, Trener trener, int ocena){
        if(ocena<6 && ocena>0){
            Ocena o = new Ocena(ocena,termin,this,trener);
            listaOcena.add(o);
            trener.oceni(o);
            System.out.println("Clan sa korisnickim imenom "+this.koristinckoIme+" je ocenio trenera "
                    +trener.getKoristinckoIme()+" ocenom "+ocena);
        } else {
            System.out.println("Ocena je izvan opsega(0<ocena>6)");
        }
    }
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
                "\r\n"+
                ", email='" + email + '\'' +
                ", datumRodjenja=" + datumRodjenja +
                ", uloga=" + uloga +
                ", aktivan=" + aktivan +
                '}'+"\r\n"+"\r\n";
    }
}
