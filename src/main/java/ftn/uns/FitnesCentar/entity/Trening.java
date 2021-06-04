package ftn.uns.FitnesCentar.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Trening implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(unique = true, name = "naziv",nullable = false)
    private String naziv;

    @Column(nullable = false, name = "nivo_treninga")
    private NIVO nivoTreninga;

    @Column(nullable = false, name = "trajanje_u_nedeljama")
    private int trajanjeUNedeljama;

    @Column(nullable = false, name = "dana_u_nedelji")
    private int danaUNedelji;

    @Column(nullable = false, name = "tip_treninga")
    private TIP tipTreninga;

    @Column(nullable = false, name = "opis")
    private String opis;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Trener trener;//TREBA

    public Trening() {}//TREBA
    //KONSTRUKTOR
    public Trening(Long id, String naziv, NIVO nivoTreninga, int trajanjeUNedeljama,
                   int danaUNedelji, TIP tipTreninga, String opis, Trener trener) {
        this.id = id;
        this.naziv = naziv;
        this.nivoTreninga = nivoTreninga;
        this.trajanjeUNedeljama = trajanjeUNedeljama;
        this.danaUNedelji = danaUNedelji;
        this.tipTreninga = tipTreninga;
        this.opis = opis;
        this.trener = trener;
    }
    //KONSTRUKTOR, bez id-a
    public Trening(String naziv, NIVO nivoTreninga, int trajanjeUNedeljama,
                   int danaUNedelji, TIP tipTreninga, String opis,Trener trener) {
        this.naziv = naziv;
        this.nivoTreninga = nivoTreninga;
        this.trajanjeUNedeljama = trajanjeUNedeljama;
        this.danaUNedelji = danaUNedelji;
        this.tipTreninga = tipTreninga;
        this.opis = opis;
        this.trener = trener;
    }
    //KONSTRUKTOR BEZ OPISA i TRENERA, bez id-a
    public Trening(String naziv, NIVO nivoTreninga,
                   int trajanjeUNedeljama, int danaUNedelji, TIP tipTreninga) {
        this.naziv = naziv;
        this.nivoTreninga = nivoTreninga;
        this.trajanjeUNedeljama = trajanjeUNedeljama;
        this.danaUNedelji = danaUNedelji;
        this.tipTreninga = tipTreninga;
    }
    //KONSTRUKTOR ZA POTREBE KONTROLERA
    public Trening(Long id, String naziv, NIVO nivoTreninga, int trajanjeUNedeljama,
                   int danaUNedelji, TIP tipTreninga, String opis) {
        this.id = id;
        this.naziv = naziv;
        this.nivoTreninga = nivoTreninga;
        this.trajanjeUNedeljama = trajanjeUNedeljama;
        this.danaUNedelji = danaUNedelji;
        this.tipTreninga = tipTreninga;
        this.opis = opis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

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

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
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
                "\r\n"+
                ", danaUNedelji=" + danaUNedelji +
                ", tipTreninga=" + tipTreninga +
                ", opis='" + opis + '\'' +
                '}'+"\r\n"+"\r\n";
    }

}
