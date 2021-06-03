package ftn.uns.FitnesCentar.controller;

import ftn.uns.FitnesCentar.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TerminController {

    @Autowired
    private TerminService terminService;
}
