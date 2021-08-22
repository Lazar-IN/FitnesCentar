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

    @Column(name = "oznaka", nullable = false)
    private String oznaka;

    @ManyToOne(fetch = FetchType.LAZY)
    private FitnessCentar fitnessCentar;

    @OneToMany(mappedBy = "sala", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Termin> terminskaLista = new HashSet<Termin>();

    public Sala() {}    //TREBA
    //KONSTRUKTOR


    public Sala(Long id, int kapacitet, String oznaka, FitnessCentar fitnessCentar,
                Set<Termin> terminskaLista) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
        this.fitnessCentar = fitnessCentar;
        this.terminskaLista = terminskaLista;
    }

    //KONSTRUKTOR,bez id-a
    public Sala(int kapacitet, String oznaka, FitnessCentar fitnessCentar, Set<Termin> terminskaLista) {
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
        this.fitnessCentar = fitnessCentar;
        this.terminskaLista = terminskaLista;
    }

    //KONSTRUKTOR BEZ TERMINSKE LISTE,bez id-a
    public Sala(int kapacitet, String oznaka) {
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
    }

    //KONSTRUKTOR ZA POTREBE CONTROLLERA
    public Sala(Long id, int kapacitet, String oznaka) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
    }

    public Sala(int kapacitet, String oznaka, Long fitnessCentarId){
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
        this.fitnessCentar.setId(fitnessCentarId);
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

    public FitnessCentar getFitnessCentar() {
        return fitnessCentar;
    }

    public void setFitnessCentar(FitnessCentar fitnessCentar) {
        this.fitnessCentar = fitnessCentar;
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
              //  ", terminskaLista=" + terminskaLista +
                '}'+"\r\n"+"\r\n";
    }
    public void stampaj(){
        System.out.println("-----SALA-----");
        System.out.println("Oznaka: "+this.oznaka);
        System.out.println("Kapacitet"+this.kapacitet);
        System.out.print("Termini: ");
        /*
        for(Termin ter : terminskaLista){
            System.out.println(ter.getTrening().getNaziv()+" - "+ter.getDatum());
        }
         */
        System.out.println(" ");
        System.out.println(" ");
    }

}
