package ftn.uns.FitnesCentar.service;

import ftn.uns.FitnesCentar.entity.Sala;
import ftn.uns.FitnesCentar.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;
}
