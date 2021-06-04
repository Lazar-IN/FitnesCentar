package ftn.uns.FitnesCentar.entity.dto;

import java.time.LocalDate;

public class TerminDTO {

    private Long id;
    private double cena;
    private LocalDate datum;
    private int brojPrijavljenih;

    public TerminDTO() {
    }

    public TerminDTO(Long id, double cena, LocalDate datum,
                     int brojPrijavljenih) {
        this.id = id;
        this.cena = cena;
        this.datum = datum;
        this.brojPrijavljenih = brojPrijavljenih;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getBrojPrijavljenih() {
        return brojPrijavljenih;
    }

    public void setBrojPrijavljenih(int brojPrijavljenih) {
        this.brojPrijavljenih = brojPrijavljenih;
    }
}
