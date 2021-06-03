package ftn.uns.FitnesCentar.repository;

import ftn.uns.FitnesCentar.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    List<Admin> findById(int id);

    List<Admin> findByKorisnickoIme(String korisnickoIme);

    List<Admin> findByIme(String ime);

    List<Admin> findByPrezime(String prezime);

    List<Admin> findByEmail(String email);

    List<Admin> findByKontaktTelefon(String telefon);

    List<Admin> findByAktivan(boolean aktivan);
}
