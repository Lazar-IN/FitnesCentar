package ftn.uns.FitnesCentar.repository;

import ftn.uns.FitnesCentar.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

    List<Sala> findById(int id);

    List<Sala> findByKapacitet(int kapacitet);

    List<Sala> findByOznaka(String oznaka);
}
