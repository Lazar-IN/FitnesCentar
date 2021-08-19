package ftn.uns.FitnesCentar.service;

import ftn.uns.FitnesCentar.entity.Termin;
import ftn.uns.FitnesCentar.repository.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminService {

    @Autowired
    private TerminRepository terminRepository;

    public Termin findOne(Long id){
        Termin termin = this.terminRepository.getOne(id);

        return termin;
    }

    public List<Termin> findAll() {
        List<Termin> termins = this.terminRepository.findAll();
        return  termins;
    }

    public Termin save(Termin termin){
        return this.terminRepository.save(termin);
    }

    public void delete(Long id){
        this.terminRepository.deleteById(id);
    }

    public Termin update(Termin termin) throws Exception{
        Termin terToUpdate = this.terminRepository.getOne(termin.getId());

        if (terToUpdate == null){
            throw new Exception("Termin ne postoji!");
        }

        terToUpdate.setCena(termin.getCena());
        terToUpdate.setDatumIVreme(termin.getDatumIVreme());

        Termin savedT = this.terminRepository.save(terToUpdate);

        return savedT;
    }
}
