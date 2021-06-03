package ftn.uns.FitnesCentar.controller;

import ftn.uns.FitnesCentar.service.OcenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OcenaController {

    @Autowired
    private OcenaService ocenaService;
}
