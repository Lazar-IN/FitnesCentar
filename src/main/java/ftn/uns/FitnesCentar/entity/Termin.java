package ftn.uns.FitnesCentar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Termin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double cena;

    @Column
    private LocalDateTime datumIVreme;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sala sala;

    @ManyToOne(fetch = FetchType.LAZY)
    private Clan clan;

    @OneToMany(mappedBy = "termin",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OdradjeniTrening> odradjeniTreninzi = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private FitnessCentar fitnessCentar;

    @ManyToOne(fetch = FetchType.LAZY)
    private Trening trening;

    @ManyToOne(fetch = FetchType.LAZY)
    private Clan odradjeniTrening;

    @ManyToOne(fetch = FetchType.LAZY)
    private Clan ocena;

    public Termin() {
    }

    public Termin(Long id, Double cena, LocalDateTime datumIVreme, Sala sala,
                  Clan clan, Set<OdradjeniTrening> odradjeniTreninzi, FitnessCentar fitnessCentar, Trening trening, Clan odradjeniTrening, Clan ocena) {
        this.id = id;
        this.cena = cena;
        this.datumIVreme = datumIVreme;
        this.sala = sala;
        this.clan = clan;
        this.odradjeniTreninzi = odradjeniTreninzi;
        this.fitnessCentar = fitnessCentar;
        this.trening = trening;
        this.odradjeniTrening = odradjeniTrening;
        this.ocena = ocena;
    }

    public Termin(Long id, double cena, LocalDateTime datumIVreme) {
        this.id = id;
        this.cena = cena;
        this.datumIVreme = datumIVreme;
    }

    public Termin( Double cena, LocalDateTime datumIVreme) {
        this.cena = cena;
        this.datumIVreme = datumIVreme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public LocalDateTime getDatumIVreme() {
        return datumIVreme;
    }

    public void setDatumIVreme(LocalDateTime datumIVreme) {
        this.datumIVreme = datumIVreme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Set<OdradjeniTrening> getOdradjeniTreninzi() {
        return odradjeniTreninzi;
    }

    public void setOdradjeniTreninzi(Set<OdradjeniTrening> odradjeniTreninzi) {
        this.odradjeniTreninzi = odradjeniTreninzi;
    }

    public FitnessCentar getFitnessCentar() {
        return fitnessCentar;
    }

    public void setFitnessCentar(FitnessCentar fitnessCentar) {
        this.fitnessCentar = fitnessCentar;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public Clan getOdradjeniTrening() {
        return odradjeniTrening;
    }

    public void setOdradjeniTrening(Clan odradjeniTrening) {
        this.odradjeniTrening = odradjeniTrening;
    }

    public Clan getOcena() {
        return ocena;
    }

    public void setOcena(Clan ocena) {
        this.ocena = ocena;
    }

    /*
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
            System.out.print(s.getKorisnickoIme()+", ");
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

     */

}
