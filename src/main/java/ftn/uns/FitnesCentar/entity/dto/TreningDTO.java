package ftn.uns.FitnesCentar.entity.dto;

import ftn.uns.FitnesCentar.entity.NIVO;
import ftn.uns.FitnesCentar.entity.TIP;

public class TreningDTO {

    private  Long id;
    private String naziv;
    private NIVO nivoTreninga;
    private int trajanjeUNedeljama;
    private int danaUNedelji;
    private TIP tipTreninga;
    private String opis;
    private Long trenerId;

    //PRAZAN KONSTRUKTOR
    public TreningDTO() {}  //TREBA

    public TreningDTO(Long id, String naziv, NIVO nivoTreninga, int trajanjeUNedeljama, int danaUNedelji, TIP tipTreninga, String opis, Long trenerId) {
        this.id = id;
        this.naziv = naziv;
        this.nivoTreninga = nivoTreninga;
        this.trajanjeUNedeljama = trajanjeUNedeljama;
        this.danaUNedelji = danaUNedelji;
        this.tipTreninga = tipTreninga;
        this.opis = opis;
        this.trenerId = trenerId;
    }

    public TreningDTO(String naziv, NIVO nivoTreninga, int trajanjeUNedeljama, int danaUNedelji, TIP tipTreninga, String opis, Long trenerId) {
        this.naziv = naziv;
        this.nivoTreninga = nivoTreninga;
        this.trajanjeUNedeljama = trajanjeUNedeljama;
        this.danaUNedelji = danaUNedelji;
        this.tipTreninga = tipTreninga;
        this.opis = opis;
        this.trenerId = trenerId;
    }

    //KONSTRUKTOR
    public TreningDTO(Long id, String naziv, NIVO nivoTreninga,
                      int trajanjeUNedeljama, int danaUNedelji, TIP tipTreninga, String opis) {
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

    public Long getTrenerId() {
        return trenerId;
    }

    public void setTrenerId(Long trenerId) {
        this.trenerId = trenerId;
    }
}
