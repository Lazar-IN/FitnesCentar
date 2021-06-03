package ftn.uns.FitnesCentar.repository;

import ftn.uns.FitnesCentar.entity.FitnessCentar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FitnesCentarRepository extends JpaRepository<FitnessCentar, Long> {

    List<FitnessCentar> findById(int id);

    List<FitnessCentar> findByNaziv(String naziv);

    List<FitnessCentar> findByAdresa(String adresa);

    List<FitnessCentar> findByBrojTelefonaCentrale(String brojTelefonaCentrale);

    List<FitnessCentar> findByEmail(String email);
}
