package ftn.uns.FitnesCentar.repository;

import ftn.uns.FitnesCentar.entity.Trener;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrenerRepository extends JpaRepository<Trener, Long> {

    List<Trener> findById(int id);

    List<Trener> findByKorisnickoIme(String korisnickoIme);

    List<Trener> findByIme(String ime);

    List<Trener> findByPrezime(String prezime);

    List<Trener> findByEmail(String email);

    List<Trener> findByKontaktTelefon(String telefon);

    List<Trener> findByAktivan(boolean aktivan);
}
