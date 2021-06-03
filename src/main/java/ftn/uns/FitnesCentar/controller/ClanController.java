package ftn.uns.FitnesCentar.controller;

import ftn.uns.FitnesCentar.service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClanController {

    @Autowired
    private ClanService clanService;
}
