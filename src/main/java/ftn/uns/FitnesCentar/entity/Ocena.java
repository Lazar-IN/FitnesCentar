package ftn.uns.FitnesCentar.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Ocena implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column
    private int ocena;

    @ManyToOne
    private Termin zaTermin;

    @ManyToOne
    private Clan odClana;

    @ManyToOne
    private Trener zaTrenera;

    public Ocena(){ }   //TREBA
    //KONSTRUKTOR
    public Ocena(Long id, int ocena, Termin zaTermin, Clan odClana, Trener zaTrenera) {
        this.id = id;
        this.ocena = ocena;
        this.zaTermin = zaTermin;
        this.odClana = odClana;
        this.zaTrenera = zaTrenera;
    }
    //KONSTRUKTOR BEZ ID-A
    public Ocena(int ocena, Termin zaTermin, Clan odClana, Trener zaTrenera) {
        this.ocena = ocena;
        this.zaTermin = zaTermin;
        this.odClana = odClana;
        this.zaTrenera = zaTrenera;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Termin getZaTermin() {
        return zaTermin;
    }

    public void setZaTermin(Termin zaTermin) {
        this.zaTermin = zaTermin;
    }

    public Clan getOdClana() {
        return odClana;
    }

    public void setOdClana(Clan odClana) {
        this.odClana = odClana;
    }

    public Trener getZaTrenera() {
        return zaTrenera;
    }

    public void setZaTrenera(Trener zaTrenera) {
        this.zaTrenera = zaTrenera;
    }

    @Override
    public String toString() {
        return "Ocena{" +
                "ocena=" + ocena +
                ", zaTermin=" + zaTermin +
                ", odClana=" + odClana +
                ", zaTrenera=" + zaTrenera +
                '}'+"\r\n"+"\r\n";
    }
}
