package ftn.uns.FitnesCentar.entity.dto;

public class TrenerLoginDTO {
    private Long id;
    private String korisnickoIme;
    private String lozinka;

    public TrenerLoginDTO(Long id, String korisnickoIme, String lozinka) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
}
