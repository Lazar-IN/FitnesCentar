package ftn.uns.FitnesCentar.controller;

import ftn.uns.FitnesCentar.entity.FitnessCentar;
import ftn.uns.FitnesCentar.entity.Termin;
import ftn.uns.FitnesCentar.entity.Trening;
import ftn.uns.FitnesCentar.entity.dto.TerminDTO;
import ftn.uns.FitnesCentar.service.FitnessCentarService;
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
@RequestMapping(value = "/api/termin")
public class TerminController {

    private final TerminService terminService;
    private final TreningService treningService;
    private final FitnessCentarService fitnessCentarService;

    @Autowired
    public TerminController(TerminService terminService, TreningService treningService, FitnessCentarService fitnesCentarService) {
        this.terminService = terminService;
        this.treningService = treningService;
        this.fitnessCentarService = fitnesCentarService;
    }
    //METODA ZA DOBAVLJANJE JEDNOG TERMINA
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> getTermin(@PathVariable("id") Long id){
        Termin termin = this.terminService.findOne(id);

        TerminDTO terminDTO = new TerminDTO();
        terminDTO.setId(termin.getId());
        terminDTO.setCena(termin.getCena());
        terminDTO.setDatumIVreme(termin.getDatumIVreme());

        return new ResponseEntity<>(terminDTO, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTermins() {

        List<Termin> terminList = this.terminService.findAll();

        List<TerminDTO> terminDTOS = new ArrayList<>();

        for (Termin termin : terminList) {
            TerminDTO terminDTO = new TerminDTO(termin.getId(),
                    termin.getCena(),termin.getDatumIVreme());

            terminDTOS.add(terminDTO);
        }
        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }
    //METODA ZA DOBAVLJANJE SVIH TERMINA ZA ODREDJENI TRENING
    @GetMapping(value = "/zaTrening/{treningId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTermins(@PathVariable("treningId") Long treningId) {

        List<Termin> terminList = this.terminService.findByTreningId(treningId);

        List<TerminDTO> terminDTOS = new ArrayList<>();

        for (Termin termin : terminList) {
            TerminDTO terminDTO = new TerminDTO(termin.getId(),
                    termin.getCena(),termin.getDatumIVreme());

            terminDTOS.add(terminDTO);
        }
        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }
    //METODA ZA KREIRANJE NOVOG TERMINA
    @PostMapping(value = "/zaTrening/{treningId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> createTermin(@RequestBody TerminDTO terminDTO, @PathVariable("treningId") Long treningId) throws Exception {
        Trening trening = treningService.findOne(treningId);
        FitnessCentar fitnessCentar = fitnessCentarService.findOne(Long.valueOf(1));
        ////////////////////////OVDE//////////////////////////

        Termin termin = new Termin(terminDTO.getCena(),
                terminDTO.getDatumIVreme());

        termin.setTrening(trening);
        termin.setFitnessCentar(fitnessCentar);

        Termin newTermin = terminService.save(termin);

        TerminDTO newTerminDTO = new TerminDTO(newTermin.getId(),
                newTermin.getCena(),newTermin.getDatumIVreme());

        return new ResponseEntity<>(newTerminDTO, HttpStatus.CREATED);
    }
    //METODA ZA AZURIRANJE POSTOJECEG TERMINA
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> updateTermin(@PathVariable Long id, @RequestBody TerminDTO terminDTO) throws Exception {

        Termin termin = new Termin(terminDTO.getId(),terminDTO.getCena(),
                terminDTO.getDatumIVreme());

        termin.setId(id);

        Termin updatedTermin = terminService.update(termin);

        TerminDTO updatedTerminDTO = new TerminDTO(updatedTermin.getId(),
                updatedTermin.getCena(),updatedTermin.getDatumIVreme());

        return new ResponseEntity<>(updatedTerminDTO, HttpStatus.OK);
    }
    //METODA ZA BRISANJE JEDNOG TERMINA
    @DeleteMapping(value = "/zaTrening/{id}")
    public ResponseEntity<Void> deleteTermin(@PathVariable Long id) {
        this.terminService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
