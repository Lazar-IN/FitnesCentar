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
    private  Long id;

    @Column(nullable = false,unique = true, name = "user")
    private String korisnickoIme;

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

    @Column(name = "prosecna_ocena")
    private long prosecnaOcena;

    @OneToMany(mappedBy = "trener", fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Trening> drziTreninge = new HashSet<Trening>();

    @OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Ocena> listaOcena = new HashSet<Ocena>();

    public Trener(){}   //TREBA
    //KONSTRUKTOR
    public Trener(String korisnickoIme, String lozinka, String ime, String prezime,
                  String kontaktTelefon, String email, LocalDate datumRodjenja,
                  Boolean aktivan, Set<Trening> drziTreninge,Set<Ocena> listaOcena) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.kontaktTelefon = kontaktTelefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.uloga = ULOGA.TRENER;
        this.aktivan = aktivan;
        this.drziTreninge = drziTreninge;
        this.listaOcena = listaOcena;
        this.prosecnaOcena = 0;
    }
    //KONSTRUKTOR BEZ LISTE
    public Trener(String korisnickoIme, String lozinka, String ime, String prezime,
                  String kontaktTelefon, String email, LocalDate datumRodjenja, Boolean aktivan) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.kontaktTelefon = kontaktTelefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.uloga = ULOGA.TRENER;
        this.aktivan = aktivan;
        this.prosecnaOcena = 0;
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

    public void setKorisnickoIme(String koristinckoIme) {
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

    public long getProsecnaOcena() {
        return prosecnaOcena;
    }

    public void setProsecnaOcena(long prosecnaOcena) {
        this.prosecnaOcena = prosecnaOcena;
    }

    public Set<Trening> getDrziTreninge() {
        return drziTreninge;
    }

    public void setDrziTreninge(Set<Trening> drziTreninge) {
        this.drziTreninge = drziTreninge;
    }

    public Set<Ocena> getListaOcena() {
        return listaOcena;
    }

    public void setListaOcena(Set<Ocena> listaOcena) {
        this.listaOcena = listaOcena;
    }

    public void dodajTreningNaListu(Trening t){
        if(drziTreninge.add(t)){
            System.out.println("Trening uspesno dodat.");
        } else{
            System.out.println("Trening nije dodat.");
        }
    }
    public void ukloniTreningSaListe(Trening t){
        if(drziTreninge.remove(t)){
            System.out.println("Trening "+t.getNaziv()+" uklonjen sa liste.");
        } else{
            System.out.println("Trening "+t.getNaziv()+" nije uklonjen sa liste!");
        }
    }
    public  void dodajTermin(FitnessCentar fc,Trening trening,int cena, LocalDate datum, Sala sala){
        Set<Sala> sale = new HashSet<Sala>();
        sale.add(sala);
        Termin termin = new Termin(trening,cena,datum,sale);
        drziTreninge.add(trening);
        fc.trenerDodajeTermin(this,termin,sala);
    }
    /*
    public void dodajSaluZaTermin(FitnessCentar fc,Termin termin,Sala sala){
        if(fc.getTreneri().contains(this)){
            fc.dodajSaluZaTermin(termin,sala);
        }else{
            System.out.println("Trener "+this.getKoristinckoIme()+" ne pripada fitnes centru "+fc.getNaziv());
        }
    }

     */
    public void oceni(Ocena o){ //KORISTITI SAMO U KLASI CLAN
            listaOcena.add(o);
            long sum=0;
            long avrg;
            for(int i=0;i<listaOcena.size();i++){
                sum+=o.getOcena();
            }
            avrg=sum/listaOcena.size();
            prosecnaOcena=avrg;

    }
    public void stampaj()
    {
        System.out.println("------"+this.uloga+"------");
        System.out.println("Korisnicko ime: "+this.korisnickoIme);
        System.out.println("Ime: "+this.ime);
        System.out.println("Prezime: "+this.prezime);
        System.out.println("Tel: "+this.kontaktTelefon);
        System.out.println("Email: "+this.email);
        System.out.println("Datum rodjenja: "+this.datumRodjenja);
        System.out.println("Prosecna ocena: "+this.prosecnaOcena);
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
    public void stampajListuTreninga(){
        System.out.println(drziTreninge);
    }//NE ZNAM DA LI RADI
    @Override
    public String toString() {
        return "Trener{" +
                "id=" + id +
                ", koristinckoIme='" + korisnickoIme + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", kontaktTelefon='" + kontaktTelefon + '\'' +
                "\r\n"+
                ", email='" + email + '\'' +
                ", datumRodjenja=" + datumRodjenja +
                ", uloga=" + uloga +
                ", aktivan=" + aktivan +
                ", prosecnaOcena=" + prosecnaOcena +
                '}'+"\r\n"+"\r\n";
    }
}
