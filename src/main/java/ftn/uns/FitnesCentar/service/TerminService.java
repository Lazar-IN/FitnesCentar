package ftn.uns.FitnesCentar.service;

import ftn.uns.FitnesCentar.repository.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerminService {

    @Autowired
    private TerminRepository terminRepository;
}
