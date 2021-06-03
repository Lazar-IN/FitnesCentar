package ftn.uns.FitnesCentar.controller;

import ftn.uns.FitnesCentar.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TrenerController {

    @Autowired
    private TrenerService trenerService;
}
