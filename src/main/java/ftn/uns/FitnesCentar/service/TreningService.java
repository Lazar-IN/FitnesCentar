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
}
