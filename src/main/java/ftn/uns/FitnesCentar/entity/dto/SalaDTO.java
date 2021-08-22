package ftn.uns.FitnesCentar.entity.dto;

public class SalaDTO {
    private Long id;
    private int kapacitet;
    private String oznaka;

    //PRAZAN KONSTRUKTOR
    public SalaDTO() { }    //TREBA
    //KONTRUKTOR
    public SalaDTO(Long id, int kapacitet, String oznaka) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
    }

    public SalaDTO(int kapacitet, String oznaka) {
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

}
