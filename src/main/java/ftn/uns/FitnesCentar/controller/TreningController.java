package ftn.uns.FitnesCentar.controller;

import ftn.uns.FitnesCentar.entity.Trening;
import ftn.uns.FitnesCentar.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TreningController {

    @Autowired
    private TreningService treningService;

    @GetMapping("http://localhost:8080/treninzi")
    public String getTrenings(Model model) {
        List<Trening> treningList = this.treningService.findAll();
        model.addAttribute("trenings", treningList);
        return "treninzi.html";
    }
}
