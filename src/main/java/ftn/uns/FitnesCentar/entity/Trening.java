package ftn.uns.FitnesCentar.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Trening implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String naziv;
    @Column
    private NIVO nivoTreninga;
    @Column
    private int trajanjeUNedeljama;
    @Column
    private int danaUNedelji;
    @Column
    private TIP tipTreninga;
    @Column
    private String opis;

    public Trening() {}//TREBA

    public Trening(String naziv, NIVO nivoTreninga, int trajanjeUNedeljama, int danaUNedelji, TIP tipTreninga) {
        this.naziv = naziv;
        this.nivoTreninga = nivoTreninga;
        this.trajanjeUNedeljama = trajanjeUNedeljama;
        this.danaUNedelji = danaUNedelji;
        this.tipTreninga = tipTreninga;
    }
    public String getNaziv() { return naziv; }
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    public NIVO getNivoTreninga() {
        return nivoTreninga;
    }
    public void setNivoTreninga(NIVO nivoTreninga) {
        this.nivoTreninga = nivoTreninga;
    }
    public int getTrajanjeUNedeljama() {
        return trajanjeUNedeljama;
    }
    public void setTrajanjeUNedeljama(int trajanjeUNedeljama) {
        this.trajanjeUNedeljama = trajanjeUNedeljama;
    }
    public int getDanaUNedelji() {
        return danaUNedelji;
    }
    public void setDanaUNedelji(int danaUNedelji) {
        this.danaUNedelji = danaUNedelji;
    }
    public TIP getTipTreninga() {
        return tipTreninga;
    }
    public void setTipTreninga(TIP tipTreninga) {
        this.tipTreninga = tipTreninga;
    }
    public String getOpis() {
        return opis;
    }
    public void setOpis(String opis) {
        this.opis = opis;
    }
    public void stampaj() {
        System.out.println("--TRENING--");
        System.out.println("Naziv: "+this.naziv);
        System.out.println("Nivo: "+this.nivoTreninga);
        System.out.println("Tip: "+this.tipTreninga);
        System.out.println("Nedelja: "+this.trajanjeUNedeljama);
        System.out.println("Dana u nedelji: "+this.danaUNedelji);
        System.out.println(" ");
        System.out.println(" ");
    }
    @Override
    public String toString() {
        return "Trening{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", nivoTreninga=" + nivoTreninga +
                ", trajanjeUNedeljama=" + trajanjeUNedeljama +
                ", danaUNedelji=" + danaUNedelji +
                ", tipTreninga=" + tipTreninga +
                ", opis='" + opis + '\'' +
                '}';
    }
}
