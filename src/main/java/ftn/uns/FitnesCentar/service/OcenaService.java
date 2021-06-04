package ftn.uns.FitnesCentar.service;

import ftn.uns.FitnesCentar.entity.Ocena;
import ftn.uns.FitnesCentar.repository.OcenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcenaService {

    @Autowired
    private OcenaRepository ocenaRepository;

    public Ocena findOne(Long id){
        Ocena ocena = this.ocenaRepository.getOne(id);

        return ocena;
    }

    public List<Ocena> findAll() {
        List<Ocena> ocenas = this.ocenaRepository.findAll();

        return ocenas;
    }

    public Ocena save(Ocena ocena){
        return this.ocenaRepository.save(ocena);
    }

    public void delete(Long id){
        this.ocenaRepository.deleteById(id);
    }
}
