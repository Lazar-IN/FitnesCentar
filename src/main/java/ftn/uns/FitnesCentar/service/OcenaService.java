package ftn.uns.FitnesCentar.service;

import ftn.uns.FitnesCentar.repository.OcenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OcenaService {

    @Autowired
    private OcenaRepository ocenaRepository;
}
