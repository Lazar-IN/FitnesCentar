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
    @Column
    private String naziv;
    @Column
    private String adresa;
    @Column
    private String brojTelefonaCentrale;
    @Column
    private String email;

    @OneToMany
    public Set<Trener> treneri = new HashSet<Trener>();//OK

    @OneToMany
    private Set<Sala> sale = new HashSet<Sala>();//OK

    private int brojTrenera;
    private int brojSala;


    public FitnessCentar() {  }//TREBA
    public FitnessCentar(String naziv, String adresa, String brojTelefonaCentrale,
                         String email, HashSet<Trener> treneri, HashSet<Sala> sale) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.email = email;
        this.treneri = treneri;
        this.sale = sale;
        this.brojTrenera=treneri.size();
        this.brojSala=sale.size();
        //FALI RASPORED
    }
    public  FitnessCentar(String naziv,String adresa, String brojTelefonaCentrale,
                          String email){
        this.naziv = naziv;
        this.adresa = adresa;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.email = email;
        this.brojTrenera=0;
        this.brojSala=0;
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
    /*
    public HashSet<Trener> getTreneri() {
        return treneri;
    }
    public void setTreneri(HashSet<Trener> treneri) {
        this.treneri = treneri;
    }
    public HashSet<Sala> getSale() {
        return sale;
    }
    public void setSale(HashSet<Sala> sale) {
        this.sale = sale;
    }
     */
    public int getBrojTrenera() {
        return brojTrenera;
    }
    public void setBrojTrenera(int brojTrenera) {
        this.brojTrenera = brojTrenera;
    }
    public int getBrojSala() {
        return brojSala;
    }
    public void setBrojSala(int brojSala) {
        this.brojSala = brojSala;
    }
    public  boolean dodajTreneraUFC(Trener t){
        if(treneri.add(t)){
            System.out.println("Trener uspesno dodat u fitnes centar");
            brojTrenera++;
            return true;
        } else {
            System.out.println("Trener nije dodat u fitnes centar");
            return false;
        }
    }
    public boolean dodajSaluUFC(Sala s){
        if(sale.add(s)){
            System.out.println("Sala dodata u fitnes centar");
            brojSala++;
            return true;
        } else {
            System.out.println("Sala nije dodadata u fitnes centar");
            return false;
        }
    }
    public void stampaj(){
        System.out.println(" ");
        System.out.println("-----FITNES CENTAR-----");
        System.out.println("Naziv: "+naziv);
        System.out.println("Adresa: "+adresa);
        System.out.println("Telefon: "+brojTelefonaCentrale);
        System.out.println("email: "+email);
        System.out.println("Broj sala: "+brojSala);
        System.out.println("Broj trenera"+brojTrenera);
        System.out.println(" ");
        System.out.println(" ");
    }
    @Override
    public String toString() {
        return "FitnessCentar{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", adresa='" + adresa + '\'' +
                ", brojTelefonaCentrale='" + brojTelefonaCentrale + '\'' +
                ", email='" + email + '\'' +
                ", brojTrenera=" + brojTrenera +
                ", brojSala=" + brojSala +
                '}';
    }
}
