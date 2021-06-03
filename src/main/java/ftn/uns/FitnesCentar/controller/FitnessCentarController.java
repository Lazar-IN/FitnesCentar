package ftn.uns.FitnesCentar.controller;

import ftn.uns.FitnesCentar.service.FitnessCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FitnessCentarController {

    @Autowired
    private FitnessCentarService fitnessCentarService;
}
