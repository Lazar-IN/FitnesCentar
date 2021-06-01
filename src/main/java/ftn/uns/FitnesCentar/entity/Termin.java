package ftn.uns.FitnesCentar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Termin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne//(cascade = CascadeType.ALL)
    private Trening trening;

    @Column(name = "cena")
    private double cena;

    @Column(name = "datum")
    private LocalDate datum;

    @ManyToOne
    private Sala sala;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)//mappedBy = "termin",   SA OVIM NE RADI
    private Set<Clan> prijavljeniClanovi = new HashSet<Clan>();

    @Column(name = "broj_prijavljenih")
    private int brojPrijavljenih;
    //PROVERITI
    @OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Ocena> listaOcena = new HashSet<Ocena>();

    public Termin() {}  //TREBA
    //KONSTRUKTOR
    public Termin(Long id, Trening trening, double cena, LocalDate datum,
                  Set<Sala> sale, Set<Clan> prijavljeniClanovi, Set<Ocena> listaOcena) {
        this.id = id;
        this.trening = trening;
        this.cena = cena;
        this.datum = datum;
        this.sala = sala;
        this.prijavljeniClanovi = prijavljeniClanovi;
        this.brojPrijavljenih = prijavljeniClanovi.size();
        this.listaOcena = listaOcena;
    }
    public Termin(Trening trening, double cena, LocalDate datum,
                  Set<Sala> sale) {
        this.trening = trening;
        this.cena = cena;
        this.datum = datum;
        this.sala = sala;
        this.brojPrijavljenih = 0;
    }
    //KONSTRUKTOR BEZ LISTI
    public Termin(Trening trening, double cena, LocalDate datum) {
        this.trening = trening;
        this.cena = cena;
        this.datum = datum;
        this.brojPrijavljenih = 0;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Set<Clan> getPrijavljeniClanovi() {
        return prijavljeniClanovi;
    }

    public void setPrijavljeniClanovi(Set<Clan> prijavljeniClanovi) {
        this.prijavljeniClanovi = prijavljeniClanovi;
    }

    public int getBrojPrijavljenih() {
        return brojPrijavljenih;
    }

    public void setBrojPrijavljenih(int brojPrijavljenih) {
        this.brojPrijavljenih = brojPrijavljenih;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Ocena> getListaOcena() {
        return listaOcena;
    }

    public void setListaOcena(Set<Ocena> listaOcena) {
        this.listaOcena = listaOcena;
    }
    /*
    public void dodajSalu(Sala s){
        if(sale.add(s)){
            System.out.println("Sala uspesno dodata.");
        } else {
            System.out.println("Sala nije dodata!");
        }
    }
    public void ukloniSalu(Sala s){
        if(sale.remove(s)){
            System.out.println("Sala uspesno uklonjena.");
        } else {
            System.out.println("Sala nije uklonjena!");
        }
    }

     */
    public void dodajClana(Clan c){
        if(prijavljeniClanovi.add(c)){
            brojPrijavljenih++;
            System.out.println("Clan dodat na listu prijavljenih.");
        } else{
            System.out.println("Clan nije dodat na listu prijavljenih!");
        }
    }
    public void ukloniClana(Clan c){
        if(prijavljeniClanovi.remove(c)){
            brojPrijavljenih--;
            System.out.println("Clan uklonjen sa liste prijavljneih.");
        } else{
            System.out.println("Clan nije uklonjen sa liste prijavljneih!");
        }
    }
    public void zaPregledTermina(){ //malo krace stampanje
        System.out.println("------TERMIN------");
        System.out.println("Trening: "+this.trening.getNaziv());
        System.out.println("Cena: "+this.cena);
        System.out.println("Datum: "+this.datum);
        System.out.println("Broj prijavljenih clanova: "+this.brojPrijavljenih);
    }
    public void stampaj()
    {
        System.out.println("------TERMIN------");
        System.out.println("Trening: "+this.trening.getNaziv());
        System.out.println("Cena: "+this.cena);
        System.out.println("Datum: "+this.datum);
        System.out.println("Broj prijavljenih clanova: "+this.brojPrijavljenih);
        System.out.print("Prijavljeni clanovi: ");
        for (Clan s : prijavljeniClanovi) {
            System.out.print(s.getKoristinckoIme()+", ");
        }
        System.out.println(" ");
        //System.out.print(prijavljeniClanovi);
        System.out.print("Sala: "+this.sala);
        System.out.println(" ");
        System.out.println(" ");
    }
    @Override
    public String toString() {
        return "Termin{" +
                "trening=" + trening +
                ", cena=" + cena +
                ", datum=" + datum +
                "\r\n"+
                ", sala=" + sala +
               // ", prijavljeniClanovi=" + prijavljeniClanovi +
                ", brojPrijavljenih=" + brojPrijavljenih +
                '}'+"\r\n"+"\r\n";
    }
}
