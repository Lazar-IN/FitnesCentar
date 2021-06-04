package ftn.uns.FitnesCentar.controller;

import ftn.uns.FitnesCentar.entity.FitnessCentar;
import ftn.uns.FitnesCentar.entity.dto.FitnessCentarDTO;
import ftn.uns.FitnesCentar.service.FitnessCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/fitnesscentar")
public class FitnessCentarController {

    private final FitnessCentarService fitnessCentarService;

    @Autowired
    public FitnessCentarController(FitnessCentarService fitnessCentarService){
        this.fitnessCentarService = fitnessCentarService;
    }
    //METODA ZA DOBAVLJANJE JEDNOG CENTRA
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> getFitnessCentar(@PathVariable("id") Long id){
        FitnessCentar fitnessCentar = this.fitnessCentarService.findOne(id);

        FitnessCentarDTO fitnessCentarDTO = new FitnessCentarDTO();
        fitnessCentarDTO.setId(fitnessCentar.getId());
        fitnessCentarDTO.setEmail(fitnessCentar.getEmail());
        fitnessCentarDTO.setNaziv(fitnessCentar.getNaziv());
        fitnessCentarDTO.setAdresa(fitnessCentar.getAdresa());
        fitnessCentarDTO.setBrojTelefonaCentrale(fitnessCentar.getBrojTelefonaCentrale());

        return new ResponseEntity<>(fitnessCentarDTO, HttpStatus.OK);
    }
    //METOD ZA DOBAVLJANJE SVIH CENTARA
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnessCentarDTO>> getFitnessCentars() {

        List<FitnessCentar> fitnessCentarList = this.fitnessCentarService.findAll();

        List<FitnessCentarDTO> fitnessCentarDTOS = new ArrayList<>();

        for(FitnessCentar fitnessCentar : fitnessCentarList){
            FitnessCentarDTO fitnessCentarDTO = new FitnessCentarDTO(fitnessCentar.getId(),
                    fitnessCentar.getNaziv(),fitnessCentar.getAdresa(), fitnessCentar.getBrojTelefonaCentrale(),
                    fitnessCentar.getEmail());

            fitnessCentarDTOS.add(fitnessCentarDTO);
        }
        return new ResponseEntity<>(fitnessCentarDTOS, HttpStatus.OK);
    }
    //METODA ZA KREIRANJE NOVOG CENTRA
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> createFitnessCentar(@RequestBody FitnessCentarDTO fitnessCentarDTO) throws Exception{

        FitnessCentar fitnessCentar = new FitnessCentar(fitnessCentarDTO.getId(),fitnessCentarDTO.getNaziv(),
                fitnessCentarDTO.getAdresa(),fitnessCentarDTO.getBrojTelefonaCentrale(),
                fitnessCentarDTO.getEmail());

        FitnessCentar newFC = fitnessCentarService.save(fitnessCentar);

        FitnessCentarDTO newFCDTO = new FitnessCentarDTO(newFC.getId(),newFC.getNaziv(),
                newFC.getAdresa(),newFC.getBrojTelefonaCentrale(),
                newFC.getEmail());

        return new ResponseEntity<>(newFCDTO, HttpStatus.CREATED);
    }
    //METODA ZA AZURIRANJE POSTOJECEG CENTRA
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> updateFitnessCentar(@PathVariable Long id, @RequestBody FitnessCentarDTO fitnessCentarDTO) throws Exception {

        FitnessCentar fitnessCentar = new FitnessCentar(fitnessCentarDTO.getId(),fitnessCentarDTO.getNaziv(),
                fitnessCentarDTO.getAdresa(),fitnessCentarDTO.getBrojTelefonaCentrale(),
                fitnessCentarDTO.getEmail());

        fitnessCentar.setId(id);

        FitnessCentar updatedFC = fitnessCentarService.update(fitnessCentar);

        FitnessCentarDTO updatedFCDTO = new FitnessCentarDTO(updatedFC.getId(),updatedFC.getNaziv(),
                updatedFC.getAdresa(),updatedFC.getBrojTelefonaCentrale(),
                updatedFC.getEmail());

        return new ResponseEntity<>(updatedFCDTO, HttpStatus.OK);
    }
    //METODA ZA BRISANJE JEDNOG CENTRA
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteClan(@PathVariable Long id) {
        this.fitnessCentarService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
