package ftn.uns.FitnesCentar.entity.dto;

public class FitnessCentarDTO {
    private Long id;
    private String naziv;
    private String adresa;
    private String brojTelefonaCentrale;
    private String email;

    //PRAZAN KONSTRUKTOR
    public FitnessCentarDTO() { }   //TREBA
    //KONTRUKTOR
    public FitnessCentarDTO(Long id, String naziv, String adresa,
                            String brojTelefonaCentrale, String email) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.email = email;
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrojTelefonaCentrale() {
        return brojTelefonaCentrale;
    }

    public void setBrojTelefonaCentrale(String brojTelefonaCentrale) {
        this.brojTelefonaCentrale = brojTelefonaCentrale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
