package ftn.uns.FitnesCentar.entity.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TerminDTO {

    private Long id;
    private double cena;
    private LocalDateTime datumIVreme;

    public TerminDTO() {
    }

    public TerminDTO(Long id, double cena, LocalDateTime datumIVreme) {
        this.id = id;
        this.cena = cena;
        this.datumIVreme = datumIVreme;
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

    public LocalDateTime getDatumIVreme() {
        return datumIVreme;
    }

    public void setDatumIVreme(LocalDateTime datumIVreme) {
        this.datumIVreme = datumIVreme;
    }

}
