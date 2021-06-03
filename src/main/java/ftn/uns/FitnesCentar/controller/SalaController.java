package ftn.uns.FitnesCentar.controller;

import ftn.uns.FitnesCentar.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SalaController {

    @Autowired
    private SalaService salaService;
}
