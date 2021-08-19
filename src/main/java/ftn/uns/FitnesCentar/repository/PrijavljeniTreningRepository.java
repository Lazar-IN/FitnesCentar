package ftn.uns.FitnesCentar.repository;

import ftn.uns.FitnesCentar.entity.PrijavljeniTrening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrijavljeniTreningRepository extends JpaRepository<PrijavljeniTrening, Long> {
    List<PrijavljeniTrening> findByClanId (Long clanId);
}
