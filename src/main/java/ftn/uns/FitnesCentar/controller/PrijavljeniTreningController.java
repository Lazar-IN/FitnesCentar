package ftn.uns.FitnesCentar.controller;


import ftn.uns.FitnesCentar.entity.Clan;
import ftn.uns.FitnesCentar.entity.PrijavljeniTrening;
import ftn.uns.FitnesCentar.entity.Termin;
import ftn.uns.FitnesCentar.entity.dto.PrijavljeniTreningDTO;
import ftn.uns.FitnesCentar.service.ClanService;
import ftn.uns.FitnesCentar.service.PrijavljeniTreningService;
import ftn.uns.FitnesCentar.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/prijavljeniTrening")
public class PrijavljeniTreningController {
    private final ClanService clanService;
    private final PrijavljeniTreningService prijavljeniTreningService;
    private final TerminService terminService;

    @Autowired
    public PrijavljeniTreningController(ClanService clanService, PrijavljeniTreningService prijavljeniTreningService, TerminService terminService){
        this.clanService = clanService;
        this.prijavljeniTreningService = prijavljeniTreningService;
        this.terminService = terminService;
    }

    @GetMapping(value = "/odClana/{clanId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PrijavljeniTreningDTO>> getPrijavljeniTreninzi(@PathVariable("clanId") Long clanId) {
        List<PrijavljeniTrening> prijavljeniTreningList = this.prijavljeniTreningService.findByClanId(clanId);

        List<PrijavljeniTreningDTO> prijavljeniTreningDTOS = new ArrayList<>();

        for(PrijavljeniTrening prijavljeniTrening: prijavljeniTreningList) {
            PrijavljeniTreningDTO prijavljeniTreningDTO = new PrijavljeniTreningDTO(prijavljeniTrening.getId(),
                    //prijavljeniTrening.getTermin().getId(),
                    //prijavljeniTrening.getTermin().getTrening().getId(),
                    prijavljeniTrening.getTermin().getTrening().getNaziv(),
                    prijavljeniTrening.getTermin().getTrening().getNivoTreninga(),
                    prijavljeniTrening.getTermin().getTrening().getDanaUNedelji(),
                    prijavljeniTrening.getTermin().getTrening().getTrajanjeUNedeljama(),
                    prijavljeniTrening.getTermin().getTrening().getTipTreninga(),
                    prijavljeniTrening.getTermin().getDatumIVreme());

            prijavljeniTreningDTOS.add(prijavljeniTreningDTO);
        }

        return new ResponseEntity<>(prijavljeniTreningDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/odClana/{clanId}/termin/{terminId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PrijavljeniTreningDTO> createPrijavljeniTrening(@PathVariable("clanId") Long clanId, @PathVariable("terminId") Long terminId) throws Exception {
        Clan clan = clanService.findOne(clanId);
        Termin termin = terminService.findOne(terminId);

        PrijavljeniTrening prijavljeniTrening = new PrijavljeniTrening();

        prijavljeniTrening.setClan(clan);
        prijavljeniTrening.setTermin(termin);

        PrijavljeniTrening newPrijavljeniTrening = prijavljeniTreningService.create(prijavljeniTrening);

        PrijavljeniTreningDTO newPrijavljeniTreningDTO = new PrijavljeniTreningDTO(newPrijavljeniTrening.getId(),
                /*newPrijavljeniTrening.getTermin().getId(), newPrijavljeniTrening.getTermin().getTrening().getId(),*/
                newPrijavljeniTrening.getTermin().getTrening().getNaziv(), newPrijavljeniTrening.getTermin().getTrening().getNivoTreninga(),
                newPrijavljeniTrening.getTermin().getTrening().getDanaUNedelji(),newPrijavljeniTrening.getTermin().getTrening().getTrajanjeUNedeljama(),
                newPrijavljeniTrening.getTermin().getTrening().getTipTreninga(),newPrijavljeniTrening.getTermin().getDatumIVreme());

        return new ResponseEntity<>(newPrijavljeniTreningDTO, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/odClana/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.prijavljeniTreningService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

