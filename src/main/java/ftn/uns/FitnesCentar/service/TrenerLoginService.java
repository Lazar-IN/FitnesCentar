package ftn.uns.FitnesCentar.service;

import ftn.uns.FitnesCentar.entity.Trener;
import ftn.uns.FitnesCentar.repository.TrenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrenerLoginService {
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
}
