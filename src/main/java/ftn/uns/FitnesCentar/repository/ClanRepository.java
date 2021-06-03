package ftn.uns.FitnesCentar.repository;

import ftn.uns.FitnesCentar.entity.Clan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClanRepository extends JpaRepository<Clan, Long> {

    List<Clan> findById(int id);

    List<Clan> findByKorisnickoIme(String korisnickoIme);

    List<Clan> findByIme(String ime);

    List<Clan> findByPrezime(String prezime);

    List<Clan> findByEmail(String email);

    List<Clan> findByKontaktTelefon(String telefon);

    List<Clan> findByAktivan(boolean aktivan);
}
