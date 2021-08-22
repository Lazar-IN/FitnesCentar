package ftn.uns.FitnesCentar.service;

import ftn.uns.FitnesCentar.entity.Sala;
import ftn.uns.FitnesCentar.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public Sala findOne(Long id){
        Sala sala = this.salaRepository.getOne(id);

        return sala;
    }

    public List<Sala> findAll() {
        List<Sala> salas = this.salaRepository.findAll();

        return salas;
    }
    public List<Sala> findByFitnessCentarId(Long fitnessCentarId) {
        List<Sala> salas = this.salaRepository.findByFitnessCentarId(fitnessCentarId);
        return salas;
    }

    public Sala save(Sala sala){
        return this.salaRepository.save(sala);
    }

    public void delete(Long id){
        this.salaRepository.deleteById(id);
    }

    public Sala update(Sala sala) throws Exception{
        Sala salaToUpdate = this.salaRepository.getOne(sala.getId());

        if (salaToUpdate == null){
            throw new Exception("Sala ne postoji!");
        }

        salaToUpdate.setKapacitet(sala.getKapacitet());
        salaToUpdate.setOznaka(sala.getOznaka());

        Sala savedS = this.salaRepository.save(salaToUpdate);

        return savedS;
    }


}
