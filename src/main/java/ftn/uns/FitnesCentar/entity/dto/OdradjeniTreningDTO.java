package ftn.uns.FitnesCentar.entity.dto;

import ftn.uns.FitnesCentar.entity.TIP;

import java.time.LocalDateTime;

public class OdradjeniTreningDTO {
    private Long id;
    private Integer ocena;
    private String naziv;
    private TIP tipTreninga;
    private LocalDateTime datumIVreme;

    public OdradjeniTreningDTO() {
    }

    public OdradjeniTreningDTO(Long id, Integer ocena, String naziv,
                               TIP tipTreninga, LocalDateTime datumIVreme) {
        this.id = id;
        this.ocena = ocena;
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

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
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

    public LocalDateTime getDatumIVreme() {
        return datumIVreme;
    }

    public void setDatumIVreme(LocalDateTime datumIVreme) {
        this.datumIVreme = datumIVreme;
    }
}
