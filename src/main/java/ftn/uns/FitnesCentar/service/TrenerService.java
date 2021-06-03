package ftn.uns.FitnesCentar.service;

import ftn.uns.FitnesCentar.repository.TrenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrenerService {

    @Autowired
    private TrenerRepository trenerRepository;
}
