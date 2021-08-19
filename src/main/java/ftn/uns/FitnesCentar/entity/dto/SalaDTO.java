package ftn.uns.FitnesCentar.entity.dto;

public class SalaDTO {
    private Long id;
    private int kapacitet;
    private String oznaka;
    private int idFC;

    //PRAZAN KONSTRUKTOR
    public SalaDTO() { }    //TREBA
    //KONTRUKTOR
    public SalaDTO(Long id, int kapacitet, String oznaka, int idFC) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
        this.idFC = idFC;
    }

    public SalaDTO(int kapacitet, String oznaka, int idFC) {
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
        this.idFC = idFC;
    }

    public SalaDTO(Long id, int idFC, int kapacitet, String oznaka, int idFC1) {
        this.id = id;
        this.idFC = idFC;
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public int getIdFC() {
        return idFC;
    }

    public void setIdFC(int idFC) {
        this.idFC = idFC;
    }
}
