package ftn.uns.FitnesCentar.entity;

import javax.persistence.*;

@Entity
public class OdradjeniTrening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Termin termin;

    @ManyToOne(fetch = FetchType.LAZY)
    private Clan clan;

    @Column
    private Integer ocena;


    public OdradjeniTrening() {
    }

    public OdradjeniTrening(Long id, Integer ocena, Termin termin,
                            Clan clan) {
        this.id = id;
        this.ocena = ocena;
        this.termin = termin;
        this.clan = clan;
    }

    public OdradjeniTrening(Long id, Termin termin, Clan clan) {
        this.id = id;
        this.termin = termin;
        this.clan = clan;
    }

    public OdradjeniTrening(Integer ocena) {
        this.ocena = ocena;
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

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }
}
