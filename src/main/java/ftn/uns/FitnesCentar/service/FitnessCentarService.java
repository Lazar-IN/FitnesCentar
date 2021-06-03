package ftn.uns.FitnesCentar.service;

import ftn.uns.FitnesCentar.repository.FitnesCentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FitnessCentarService {

    @Autowired
    private FitnesCentarRepository fitnesCentarRepository;
}
