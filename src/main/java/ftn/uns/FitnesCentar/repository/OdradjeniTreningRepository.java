package ftn.uns.FitnesCentar.repository;

import ftn.uns.FitnesCentar.entity.OdradjeniTrening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OdradjeniTreningRepository extends JpaRepository<OdradjeniTrening, Long> {
    List<OdradjeniTrening> findByClanId(Long clanId);
}
