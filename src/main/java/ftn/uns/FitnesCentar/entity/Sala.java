package ftn.uns.FitnesCentar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kapacitet")
    private int kapacitet;

    @Column(name = "oznaka", nullable = false, unique = true)
    private String oznaka;

    @ManyToMany
    private Set<Termin> terminskaLista = new HashSet<Termin>(); //veza N:N

    public Sala() {}    //TREBA
    //KONSTRUKTOR
    public Sala(int kapacitet, String oznaka, Set<Termin> terminskaLista) {
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
        this.terminskaLista = terminskaLista;
    }
    //KONSTRUKTOR BEZ TERMINSKE LISTE
    public Sala(int kapacitet, String oznaka) {
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public Set<Termin> getTerminskaLista() {
        return terminskaLista;
    }

    public void setTerminskaLista(Set<Termin> terminskaLista) {
        this.terminskaLista = terminskaLista;
    }
    //DODAVANJE TERMINA NA TERMINSKU LISTU
    public void dodajTermin(Termin t){
        if(terminskaLista.add(t)){
            System.out.println("Termin uspesno dodat na terminskuListu.");
        } else {
            System.out.println("Termin nije dodat na terminskuListu!");
        }
    }
    public void ukloniTermin(Termin t){
        if(terminskaLista.remove(t)){
            System.out.println("Termin uklonjen sa terminskeListe.");
        } else {
            System.out.println("Termin nije uklonjen sa terminskeListe!");
        }
    }
    @Override
    public String toString() {
        return "Sala{" +
                "kapacitet=" + kapacitet +
                ", oznaka='" + oznaka + '\'' +
                "\r\n"+
                ", terminskaLista=" + terminskaLista +
                '}'+"\r\n"+"\r\n";
    }
    public void stampaj(){
        System.out.println("-----SALA-----");
        System.out.println("Oznaka: "+this.oznaka);
        System.out.println("Kapacitet"+this.kapacitet);
        System.out.print("Termini: ");
        for(Termin ter : terminskaLista){
            System.out.println(ter.getTrening().getNaziv()+" - "+ter.getDatum());
        }
        System.out.println(" ");
        System.out.println(" ");
    }

}
