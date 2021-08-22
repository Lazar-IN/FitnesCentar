package ftn.uns.FitnesCentar.service;

import ftn.uns.FitnesCentar.entity.Trening;
import ftn.uns.FitnesCentar.repository.TreningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreningService {

    @Autowired
    private TreningRepository treningRepository;

    public Trening findOne(Long id){
        Trening trening = this.treningRepository.getOne(id);

        return trening;
    }

    public List<Trening> findAll() {
        List<Trening> trenings = this.treningRepository.findAll();
        return  trenings;
    }

    public Trening save(Trening trening){
        return this.treningRepository.save(trening);
    }

    public void delete(Long id){

        this.treningRepository.deleteById(id);

    }

    public Trening update(Trening trening) throws Exception{
        Trening treningToUpdate = this.treningRepository.getOne(trening.getId());
        if (treningToUpdate == null){
            throw new Exception("Trening ne postoji!");
        }

        treningToUpdate.setNaziv(trening.getNaziv());
        treningToUpdate.setTipTreninga(trening.getTipTreninga());
        treningToUpdate.setNivoTreninga(trening.getNivoTreninga());
        treningToUpdate.setDanaUNedelji(trening.getDanaUNedelji());
        treningToUpdate.setTrajanjeUNedeljama(trening.getTrajanjeUNedeljama());
        treningToUpdate.setOpis(trening.getOpis());

        Trening savedTr = this.treningRepository.save(treningToUpdate);

        return savedTr;
    }


    public List<Trening> findByTrenerId(Long trenerId) {
        List<Trening> trenings = this.treningRepository.findByTrenerId(trenerId);
        return trenings;
    }
}
