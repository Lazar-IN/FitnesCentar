package ftn.uns.FitnesCentar.repository;

import ftn.uns.FitnesCentar.entity.NIVO;
import ftn.uns.FitnesCentar.entity.TIP;
import ftn.uns.FitnesCentar.entity.Trening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreningRepository extends JpaRepository<Trening, Long> {
    List<Trening> findByNivoTreninga(NIVO nivoTreninga);

    List<Trening> findByDanaUNedelji(int danaUNedelji);

    List<Trening> findByTrajanjeUNedeljama(int trajanjeUNedeljama);

    List<Trening> findByTipTreninga(TIP tipTreninga);
}

