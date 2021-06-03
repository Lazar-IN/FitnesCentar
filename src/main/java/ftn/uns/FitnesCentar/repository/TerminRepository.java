package ftn.uns.FitnesCentar.repository;

import ftn.uns.FitnesCentar.entity.Sala;
import ftn.uns.FitnesCentar.entity.Termin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TerminRepository extends JpaRepository<Termin, Long> {

    List<Termin> findById(int id);

    List<Termin> findByCena(double cena);

    List<Termin> findByDatum(LocalDate datum);

    List<Termin> findBySala(Sala sala);

    List<Termin> findByBrojPrijavljenih(int brojPrijavljenih);
}
