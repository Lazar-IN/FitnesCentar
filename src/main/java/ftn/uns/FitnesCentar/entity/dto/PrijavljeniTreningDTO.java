package ftn.uns.FitnesCentar.entity.dto;

import ftn.uns.FitnesCentar.entity.NIVO;
import ftn.uns.FitnesCentar.entity.TIP;

import java.time.LocalDateTime;

public class PrijavljeniTreningDTO {
    private Long id;
    //private Long terminId;
    //private Long terminTreningId;
    private String naziv;
    private NIVO nivoTreninga;
    private int danaUNedelji;
    private int trajanjeUNedeljama;
    private TIP tipTreninga;
    private LocalDateTime datumIVreme;

    public PrijavljeniTreningDTO() {
    }

    public PrijavljeniTreningDTO(Long id, String naziv, NIVO nivoTreninga, int danaUNedelji, int trajanjeUNedeljama, TIP tipTreninga, LocalDateTime datumIVreme) {
        this.id = id;
        this.naziv = naziv;
        this.nivoTreninga = nivoTreninga;
        this.danaUNedelji = danaUNedelji;
        this.trajanjeUNedeljama = trajanjeUNedeljama;
        this.tipTreninga = tipTreninga;
        this.datumIVreme = datumIVreme;
    }


    public PrijavljeniTreningDTO(String naziv, NIVO nivoTreninga, int danaUNedelji, int trajanjeUNedeljama, TIP tipTreninga, LocalDateTime datumIVreme) {
        this.naziv = naziv;
        this.nivoTreninga = nivoTreninga;
        this.danaUNedelji = danaUNedelji;
        this.trajanjeUNedeljama = trajanjeUNedeljama;
        this.tipTreninga = tipTreninga;
        this.datumIVreme = datumIVreme;
    }

    public PrijavljeniTreningDTO(Long id, String naziv, TIP tipTreninga, LocalDateTime datumIVreme) {
        this.id = id;
        this.naziv = naziv;
        this.tipTreninga = tipTreninga;
        this.datumIVreme = datumIVreme;
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

    public TIP getTipTreninga() {
        return tipTreninga;
    }

    public void setTipTreninga(TIP tipTreninga) {
        this.tipTreninga = tipTreninga;
    }



    public NIVO getNivoTreninga() {
        return nivoTreninga;
    }

    public void setNivoTreninga(NIVO nivoTreninga) {
        this.nivoTreninga = nivoTreninga;
    }

    public int getDanaUNedelji() {
        return danaUNedelji;
    }

    public void setDanaUNedelji(int danaUNedelji) {
        this.danaUNedelji = danaUNedelji;
    }


    public int getTrajanjeUNedeljama() {
        return trajanjeUNedeljama;
    }

    public void setTrajanjeUNedeljama(int trajanjeUNedeljama) {
        this.trajanjeUNedeljama = trajanjeUNedeljama;
    }

    public LocalDateTime getDatumIVreme() {
        return datumIVreme;
    }

    public void setDatumIVreme(LocalDateTime datumIVreme) {
        this.datumIVreme = datumIVreme;
    }
}
