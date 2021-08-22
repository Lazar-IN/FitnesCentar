package ftn.uns.FitnesCentar.controller;

import ftn.uns.FitnesCentar.entity.Clan;
import ftn.uns.FitnesCentar.entity.OdradjeniTrening;
import ftn.uns.FitnesCentar.entity.Termin;
import ftn.uns.FitnesCentar.entity.Trening;
import ftn.uns.FitnesCentar.entity.dto.OdradjeniTreningDTO;
import ftn.uns.FitnesCentar.service.ClanService;
import ftn.uns.FitnesCentar.service.OdradjeniTreningService;
import ftn.uns.FitnesCentar.service.TerminService;
import ftn.uns.FitnesCentar.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/odradjeniTrening")
public class OdradjeniTreningController {
    private final OdradjeniTreningService odradjeniTreningService;
    private final ClanService clanService;
    private final TerminService terminService;

    @Autowired
    public OdradjeniTreningController(OdradjeniTreningService odradjeniTreningService,
                                      ClanService clanService, TerminService terminService) {
        this.odradjeniTreningService = odradjeniTreningService;
        this.clanService = clanService;
        this.terminService = terminService;
    }


    //PO ID-U
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OdradjeniTreningDTO> getOdradjeniTrening(@PathVariable("id") Long id) {
        OdradjeniTrening odradjeniTrening = this.odradjeniTreningService.findOne(id);

        OdradjeniTreningDTO odradjeniTreningDTO = new OdradjeniTreningDTO();
        odradjeniTreningDTO.setId(odradjeniTrening.getId());
        odradjeniTreningDTO.setOcena(odradjeniTrening.getOcena());
        odradjeniTreningDTO.setNaziv(odradjeniTrening.getTermin().getTrening().getNaziv());
        odradjeniTreningDTO.setNivoTreninga(odradjeniTrening.getTermin().getTrening().getNivoTreninga());
        odradjeniTreningDTO.setTipTreninga(odradjeniTrening.getTermin().getTrening().getTipTreninga());
        odradjeniTreningDTO.setDatumIVreme(odradjeniTrening.getTermin().getDatumIVreme());

        return new ResponseEntity<>(odradjeniTreningDTO, HttpStatus.OK);
    }


    // OD CLANA
    @GetMapping(value = "/odClana/{clanId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OdradjeniTreningDTO>> getOdradjeniTreningId(@PathVariable("clanId") Long clanId) {
        List<OdradjeniTrening> odradjeniTreningList = this.odradjeniTreningService.findByClanId(clanId);

        List<OdradjeniTreningDTO> odradjeniTreningDTOS = new ArrayList<>();

        for(OdradjeniTrening odradjeniTrening: odradjeniTreningList) {
            OdradjeniTreningDTO odradjeniTreningDTO = new OdradjeniTreningDTO(odradjeniTrening.getId(),
                    odradjeniTrening.getOcena(),
                    odradjeniTrening.getTermin().getTrening().getNaziv(),
                    odradjeniTrening.getTermin().getTrening().getNivoTreninga(),
                    odradjeniTrening.getTermin().getTrening().getTipTreninga(),
                    odradjeniTrening.getTermin().getDatumIVreme());

                    odradjeniTreningDTOS.add(odradjeniTreningDTO);
        }

        return new ResponseEntity<>(odradjeniTreningDTOS, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OdradjeniTreningDTO> updateOdradjenihTreninga(@PathVariable Long id, @RequestBody OdradjeniTreningDTO odradjeniTreningDTO) throws Exception {
        OdradjeniTrening odradjeniTrening = new OdradjeniTrening(odradjeniTreningDTO.getOcena());
        odradjeniTrening.setId(id);

        OdradjeniTrening updatedOdradjeniTrening = odradjeniTreningService.update(odradjeniTrening);

        OdradjeniTreningDTO updatedOdradjeniTreningDTO = new OdradjeniTreningDTO(updatedOdradjeniTrening.getId(), updatedOdradjeniTrening.getOcena(),
                updatedOdradjeniTrening.getTermin().getTrening().getNaziv(),updatedOdradjeniTrening.getTermin().getTrening().getNivoTreninga(), updatedOdradjeniTrening.getTermin().getTrening().getTipTreninga(), updatedOdradjeniTrening.getTermin().getDatumIVreme());

        return new ResponseEntity<>(updatedOdradjeniTreningDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/odClana/{clanId}/termin/{terminId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OdradjeniTreningDTO> createOdradjeniTrening(@PathVariable("clanId") Long clanId, @PathVariable("terminId") Long terminId) throws Exception {
        Clan clan = clanService.findOne(clanId);
        Termin termin = terminService.findOne(terminId);

        OdradjeniTrening odradjeniTrening = new OdradjeniTrening();

        odradjeniTrening.setClan(clan);
        odradjeniTrening.setTermin(termin);

        OdradjeniTrening newOdradjeniTrening = odradjeniTreningService.create(odradjeniTrening);

        OdradjeniTreningDTO newOdradjeniTreningDTO = new OdradjeniTreningDTO(newOdradjeniTrening.getId(),
                newOdradjeniTrening.getOcena(),
                newOdradjeniTrening.getTermin().getTrening().getNaziv(),
                newOdradjeniTrening.getTermin().getTrening().getNivoTreninga(),
                newOdradjeniTrening.getTermin().getTrening().getTipTreninga(),
                newOdradjeniTrening.getTermin().getDatumIVreme());

        return new ResponseEntity<>(newOdradjeniTreningDTO, HttpStatus.CREATED);
    }
}
