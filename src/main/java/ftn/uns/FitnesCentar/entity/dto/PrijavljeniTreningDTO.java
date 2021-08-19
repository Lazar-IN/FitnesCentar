package ftn.uns.FitnesCentar.entity.dto;

import ftn.uns.FitnesCentar.entity.TIP;

import java.time.LocalDateTime;

public class PrijavljeniTreningDTO {
    private Long id;
    private String naziv;
    private TIP tipTreninga;
    private LocalDateTime datumIVreme;

    public PrijavljeniTreningDTO() {
    }

    public PrijavljeniTreningDTO(Long id, String naziv, TIP tipTreninga,
                                 LocalDateTime datumIVreme) {
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

    public LocalDateTime getdatumIVreme() {
        return datumIVreme;
    }

    public void setdatumIVreme(LocalDateTime datumIVreme) {
        this.datumIVreme = datumIVreme;
    }
}
