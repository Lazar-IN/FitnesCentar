package ftn.uns.FitnesCentar.service;

import ftn.uns.FitnesCentar.entity.Trener;
import ftn.uns.FitnesCentar.repository.TrenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrenerService {

    @Autowired
    private TrenerRepository trenerRepository;

    public Trener findOne(Long id){
        Trener trener = this.trenerRepository.getOne(id);

        return trener;
    }

    public List<Trener> findAll() {
        List<Trener> treners = this.trenerRepository.findAll();

        return treners;
    }

    public Trener save(Trener trener){
        return this.trenerRepository.save(trener);
    }

    public void delete(Long id){
        this.trenerRepository.deleteById(id);
    }

    public Trener update(Trener trener) throws Exception{
        Trener trenerToUpdate = this.trenerRepository.getOne(trener.getId());

        if (trenerToUpdate == null){
            throw new Exception("Trener ne postoji!");
        }

        trenerToUpdate.setKorisnickoIme(trener.getKorisnickoIme());
        trenerToUpdate.setIme(trener.getIme());
        trenerToUpdate.setPrezime(trener.getPrezime());
        trenerToUpdate.setDatumRodjenja(trener.getDatumRodjenja());
        trenerToUpdate.setEmail(trener.getEmail());
        trenerToUpdate.setUloga(trener.getUloga());
        trenerToUpdate.setAktivan(trener.getAktivan());

        Trener savedTr = this.trenerRepository.save(trenerToUpdate);

        return savedTr;
    }
}
