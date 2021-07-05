package ftn.uns.FitnesCentar.controller;

import ftn.uns.FitnesCentar.entity.Termin;
import ftn.uns.FitnesCentar.entity.dto.TerminDTO;
import ftn.uns.FitnesCentar.service.TerminService;
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

    @Autowired
    public TerminController(TerminService terminService){
        this.terminService = terminService;
    }
    //METODA ZA DOBAVLJANJE JEDNOG TERMINA
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> getTermin(@PathVariable("id") Long id){
        Termin termin = this.terminService.findOne(id);

        TerminDTO terminDTO = new TerminDTO();
        terminDTO.setId(termin.getId());
        terminDTO.setCena(termin.getCena());
        terminDTO.setDatum(termin.getDatum());
        terminDTO.setBrojPrijavljenih(termin.getBrojPrijavljenih());

        return new ResponseEntity<>(terminDTO, HttpStatus.OK);
    }
    //METODA ZA DOBAVLJANJE SVIH CLANOVA
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTermin() {

        List<Termin> terminList = this.terminService.findAll();

        List<TerminDTO> terminDTOS = new ArrayList<>();

        for (Termin termin : terminList) {
            TerminDTO terminDTO = new TerminDTO(termin.getId(),
                    termin.getCena(),termin.getDatum(),termin.getBrojPrijavljenih());

            terminDTOS.add(terminDTO);
        }
        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }
    //METODA ZA KREIRANJE NOVOG TERMINA
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> createTermin(@RequestBody TerminDTO terminDTO) throws Exception {

        Termin termin = new Termin(terminDTO.getId(),terminDTO.getCena(),
                terminDTO.getDatum(),terminDTO.getBrojPrijavljenih());

        Termin newTermin = terminService.save(termin);

        TerminDTO newTerminDTO = new TerminDTO(newTermin.getId(),
                newTermin.getCena(),newTermin.getDatum(),
                newTermin.getBrojPrijavljenih());

        return new ResponseEntity<>(newTerminDTO, HttpStatus.CREATED);
    }
    //METODA ZA AZURIRANJE POSTOJECEG TERMINA
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> updateTermin(@PathVariable Long id, @RequestBody TerminDTO terminDTO) throws Exception {

        Termin termin = new Termin(terminDTO.getId(),terminDTO.getCena(),
                terminDTO.getDatum(),terminDTO.getBrojPrijavljenih());

        termin.setId(id);

        Termin updatedTermin = terminService.update(termin);

        TerminDTO updatedTerminDTO = new TerminDTO(updatedTermin.getId(),
                updatedTermin.getCena(),updatedTermin.getDatum(),
                updatedTermin.getBrojPrijavljenih());

        return new ResponseEntity<>(updatedTerminDTO, HttpStatus.OK);
    }
    //METODA ZA BRISANJE JEDNOG TERMINA
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteClan(@PathVariable Long id) {
        this.terminService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
