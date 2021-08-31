package ftn.uns.FitnesCentar.service;

import ftn.uns.FitnesCentar.entity.FitnessCentar;
import ftn.uns.FitnesCentar.repository.FitnesCentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnessCentarService {

    @Autowired
    private FitnesCentarRepository fitnesCentarRepository;

    public FitnessCentar findOne(Long id){
        FitnessCentar fitnessCentar = this.fitnesCentarRepository.getOne(id);

        return fitnessCentar;
    }

    public List<FitnessCentar> findAll() {
        List<FitnessCentar> fitnessCentars = this.fitnesCentarRepository.findAll();

        return fitnessCentars;
    }

    public FitnessCentar save(FitnessCentar fitnessCentar) throws Exception{
        if (fitnessCentar.getId() != null){
            throw new Exception("Id mora biti null");
        }

        FitnessCentar newFitnessCentar = this.fitnesCentarRepository.save(fitnessCentar);
        return newFitnessCentar;
    }

    public void delete(Long id){
        this.fitnesCentarRepository.deleteById(id);
    }

    public FitnessCentar update(FitnessCentar fitnessCentar) throws Exception{
        FitnessCentar fcToUpdate = this.fitnesCentarRepository.getOne(fitnessCentar.getId());

        if (fcToUpdate == null){
            throw new Exception("Fitnes centar ne postoji!");
        }

        fcToUpdate.setNaziv(fitnessCentar.getNaziv());
        fcToUpdate.setEmail(fitnessCentar.getEmail());
        fcToUpdate.setAdresa(fitnessCentar.getAdresa());
        fcToUpdate.setBrojTelefonaCentrale(fitnessCentar.getBrojTelefonaCentrale());

        FitnessCentar savedFc = this.fitnesCentarRepository.save(fcToUpdate);

        return savedFc;
    }
}
