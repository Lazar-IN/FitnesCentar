package ftn.uns.FitnesCentar.service;

import ftn.uns.FitnesCentar.repository.ClanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClanService {

    @Autowired
    private ClanRepository clanRepository;
}
