package ftn.uns.FitnesCentar.service;

import ftn.uns.FitnesCentar.entity.PrijavljeniTrening;
import ftn.uns.FitnesCentar.repository.PrijavljeniTreningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrijavljeniTreningService {
    @Autowired
    private PrijavljeniTreningRepository prijavljeniTreningRepository;

    public PrijavljeniTrening findOne(Long id){
        PrijavljeniTrening prijavljeniTrening = this.prijavljeniTreningRepository.getOne(id);

        return prijavljeniTrening;
    }
    public List<PrijavljeniTrening> findByClanId(Long clanId) {
        List<PrijavljeniTrening> prijavljeniTrenings = this.prijavljeniTreningRepository.findByClanId(clanId);

        return prijavljeniTrenings;
    }

    public void delete(Long id) {
        this.prijavljeniTreningRepository.deleteById(id);
    }

    public PrijavljeniTrening create(PrijavljeniTrening prijavljeniTrening) throws Exception{
        if(prijavljeniTrening.getId() != null){
            throw new Exception("ID mora biti null!");
        }
        PrijavljeniTrening newPrijavljeniTrening = this.prijavljeniTreningRepository.save(prijavljeniTrening);

        return newPrijavljeniTrening;
    }
}
