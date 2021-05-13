package ftn.uns.FitnesCentar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class FitnessCentar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "naziv")
    private String naziv;

    @Column(name = "adresa")
    private String adresa;

    @Column(name = "broj_telefona_centrale")
    private String brojTelefonaCentrale;

    @Column(name = "email")
    private String email;

    //lista trenera koji rade u tom fitnes centru
    @OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Trener> treneri = new HashSet<Trener>();

    //lista sala koje se nalaze u tom fitnes centru
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Sala> sale = new HashSet<Sala>();//OK

    //raspored odrzavanja treninga
    @OneToMany
    private Set<Termin> raspored = new HashSet<Termin>();

    public FitnessCentar() {}   //TREBA
    //KONSTRUKTOR
    public FitnessCentar(String naziv, String adresa, String brojTelefonaCentrale,
                         String email, Set<Trener> treneri, Set<Sala> sale,Set<Termin> raspored) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.email = email;
        this.treneri = treneri;
        this.sale = sale;
        this.raspored = raspored;
    }
    //KONSTUKTOR BEZ LISTI
    public FitnessCentar(String naziv, String adresa,
                         String brojTelefonaCentrale, String email) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.email = email;
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

    public String getBrojTelefonaCentrale() {
        return brojTelefonaCentrale;
    }

    public void setBrojTelefonaCentrale(String brojTelefonaCentrale) {
        this.brojTelefonaCentrale = brojTelefonaCentrale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Trener> getTreneri() {
        return treneri;
    }

    public void setTreneri(Set<Trener> treneri) {
        this.treneri = treneri;
    }

    public Set<Sala> getSale() {
        return sale;
    }

    public void setSale(Set<Sala> sale) {
        this.sale = sale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Termin> getRaspored() {
        return raspored;
    }

    public void setRaspored(Set<Termin> raspored) {
        this.raspored = raspored;
    }
    //DODAVANJE/UKLANJANJE TRENERA U FITNES CENTAR
    public void dodajTrenerra(Trener t){
        if(treneri.add(t)){
            System.out.println("Trener uspesno dodat u fitnes centar.");
        } else{
            System.out.println("Trener nije dodat u fitnes centar!");
        }
    }
    public void ukloniTrenerra(Trener t){
        if(treneri.remove(t)){
            System.out.println("Trener uklonjen iz fitnes centar.");
        } else{
            System.out.println("Trener nije uklonjen iz fitnes centar!");
        }
    }
    //DODAVANJE/UKLANJANJE SALE IZ FC
    public void dodajSalu(Sala s){
        if(sale.add(s)){
            System.out.println("Sala uspesno dodata u fitnes centar.");
        } else {
            System.out.println("Sala nije dodata u fitnes centar!");
        }
    }
    public void ukloniSalu(Sala s){
        if(sale.remove(s)){
            System.out.println("Sala uspesno uklonjena iz fitnes centra.");
        } else {
            System.out.println("Sala nije uklonjena iz fitnes centra!");
        }
    }
    //FUNKCIJE ZA RASPORED ODRZAVANJA TRENINGA
    public void trenerDodajeTermin(Trener trener,Termin termin,Sala sala){
        if(treneri.contains(trener)){
            if(sale.contains(sala)){
                //GLAVNO
                raspored.add(termin);
            }else{
                System.out.println("Sala "+sala.getOznaka()+" ne pripada fitnes centru"+this.getNaziv());
            }
        } else{
            System.out.println("Trener "+trener.getKoristinckoIme()+" ne pripada fitnes centru "+this.getNaziv());
        }
    }
    public void dodajSaluZaTermin(Termin termin,Sala sala){
        if(raspored.contains(termin)){
            if(sale.contains(sala)){
                //ovde///////
                termin.dodajSalu(sala);
                raspored.remove(termin);
                raspored.add(termin);
            }else {
                System.out.println("Sala je nepostojeca!");
            }
        }else{
            System.out.println("Termin je nepostojeci!");
        }
    }
    //STAMPA TERMINE U FC
    public void pregledTermina(){
        if(raspored.isEmpty()){
            System.out.println("Raspored termina je trenutno prazan.");
        }else{
            System.out.println("---RASPORED TERMINA---");
            for(Termin str : raspored) {
                str.zaPregledTermina();
            }
            System.out.println("-----------------------------------------");
        }

    }

    public void stampaj(){
        System.out.println(" ");
        System.out.println("-----FITNES CENTAR-----");
        System.out.println("Naziv: "+this.naziv);
        System.out.println("Adresa: "+this.adresa);
        System.out.println("Telefon: "+this.brojTelefonaCentrale);
        System.out.println("email: "+this.email);
        System.out.println("Broj sala: "+this.sale.size());
        System.out.println("Broj trenera"+ this.treneri.size());
        System.out.println(" ");
        System.out.println(" ");
    }

    @Override
    public String toString() {
        return "FitnessCentar{" +
                "naziv='" + naziv + '\'' +
                ", adresa='" + adresa + '\'' +
                ", brojTelefonaCentrale='" + brojTelefonaCentrale + '\'' +
                "\r\n"+
                ", email='" + email + '\'' +
                ", treneri=" + treneri +
                ", sale=" + sale +
                '}'+"\r\n"+"\r\n";
    }

}
