package ftn.uns.FitnesCentar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Termin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    public Trening trening;

    @Column
    private double cena;

    @Column
    private LocalDate datum;

    @ManyToMany
    public Set<Sala> sale = new HashSet<Sala>();//veza N:N

    @Column
    private int brojSala;

    @ManyToMany
    public Set<Clan> prijavljeniClanovi = new HashSet<Clan>();

    @Column
    private int brojPrijavljenih;

    public  Termin(){ }//TREBA
    public Termin(Trening trening, double cena, LocalDate datum,
                  HashSet<Sala> sale, HashSet<Clan> prijavljeniClanovi) {
        this.trening = trening;
        this.cena = cena;
        this.datum = datum;
        this.sale = sale;
        this.prijavljeniClanovi = prijavljeniClanovi;
        this.brojPrijavljenih=prijavljeniClanovi.size();
        this.brojSala=sale.size();
    }
    public Termin(Trening trening, double cena, LocalDate datum) {  //KONSTRUKTOR BEZ LISTI
        this.trening = trening;
        this.cena = cena;
        this.datum = datum;
        this.brojSala=0;
        this.brojPrijavljenih=0;
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

    public boolean dodajSalu(Sala s)
    {
        if(sale.add(s))
        {
            System.out.println("Sala uspesno dodata.");
            brojSala++;
            return true;
        }
        else
        {
            System.out.println("Sala nije dodata!");
            return false;
        }
    }
    public boolean dodajClana(Clan s)
    {
        if(prijavljeniClanovi.add(s))
        {
            System.out.println("Clan uspesno dodat na spisak prijavljnih.");
            brojPrijavljenih++;
            return true;
        }
        else
        {
            System.out.println("Clan nije dodat na spisak prijavljnih!");
            return false;
        }
    }
    @Override
    public String toString() {
        return "Termin{" +
                "trening=" + trening +
                ", cena=" + cena +
                ", datum=" + datum +
                ", brojSala=" + brojSala +
                ", brojPrijavljenih=" + brojPrijavljenih +
                '}';
    }
}
