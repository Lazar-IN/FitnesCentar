package ftn.uns.FitnesCentar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int kapacitet;
    @Column
    private String oznaka;

    @ManyToOne
    private FitnessCentar fc;

    @ManyToMany
    public Set<Termin> terminskaLista = new HashSet<Termin>();  //veza N:N

    public Sala() {  }//TREBA
    public Sala(int kapacitet, String oznaka) {
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
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

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", kapacitet=" + kapacitet +
                ", oznaka='" + oznaka + '\'' +
                ", terminskaLista=" + terminskaLista +
                '}';
    }
}
