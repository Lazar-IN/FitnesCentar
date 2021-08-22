package ftn.uns.FitnesCentar.controller;

import ftn.uns.FitnesCentar.entity.Sala;
import ftn.uns.FitnesCentar.entity.dto.SalaDTO;
import ftn.uns.FitnesCentar.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/sala")
public class SalaController {

    private final SalaService salaService;

    @Autowired
    public SalaController(SalaService salaService){
        this.salaService = salaService;
    }
    //METODA ZA DOBAVLJANJE JEDNE SALE
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> getSala(@PathVariable("id") Long id){
        Sala sala = this.salaService.findOne(id);

        SalaDTO salaDTO = new SalaDTO();
        salaDTO.setId(sala.getId());
        salaDTO.setKapacitet(sala.getKapacitet());
        salaDTO.setOznaka(sala.getOznaka());

        return new ResponseEntity<>(salaDTO, HttpStatus.OK);
    }
    //METODA ZA DOBAVLJANJE SVIH SALA
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaDTO>> getSalas() {

        List<Sala> salaList = this.salaService.findAll();

        List<SalaDTO> salaDTOS = new ArrayList<>();

        for (Sala sala : salaList) {
            SalaDTO salaDTO = new SalaDTO(sala.getId(),sala.getKapacitet(),
                    sala.getOznaka());

            salaDTOS.add(salaDTO);
        }
        return new ResponseEntity<>(salaDTOS, HttpStatus.OK);
    }
    //METODA ZA DOBAVLJANJE SVIH SALA IZ JEDNOG FITNESS CENTRA
    @GetMapping(value = "/zaFitnessCentar/{fitnessCentarId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaDTO>> getSalas(@PathVariable("fitnessCentarId") Long fitnessCentarId) {

        List<Sala> salaList =this.salaService.findByFitnessCentarId(fitnessCentarId);

        List<SalaDTO> salaDTOS = new ArrayList<>();

        for (Sala sala : salaList) {
            SalaDTO salaDTO = new SalaDTO(sala.getId(),sala.getKapacitet(),
                    sala.getOznaka());

            salaDTOS.add(salaDTO);
        }
        return new ResponseEntity<>(salaDTOS, HttpStatus.OK);
    }
    //METODA ZA KREIRANJE NOVE SALE u JEDNOM FITNESS CENTRU
    @PostMapping(value = "/zaFitnessCentar/{fitnessCentarId}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> createSala(@RequestBody SalaDTO salaDTO, @PathVariable("fitnessCentarId") Long fitnessCentarId) throws Exception {

        Sala sala = new Sala(salaDTO.getId(),
                salaDTO.getKapacitet(),salaDTO.getOznaka());

        Sala newSala = salaService.save(sala);

        SalaDTO newSalaDTO = new SalaDTO(newSala.getId(),
                newSala.getKapacitet(),newSala.getOznaka());

        return new ResponseEntity<>(newSalaDTO, HttpStatus.CREATED);
    }
    //METODA ZA AZURIRANJE POSTOJECE SALE
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> updateSala(@PathVariable Long id, @RequestBody SalaDTO salaDTO) throws Exception {

        Sala sala = new Sala(salaDTO.getId(),
                salaDTO.getKapacitet(),salaDTO.getOznaka());

        sala.setId(id);

        Sala updatedSala = salaService.update(sala);

        SalaDTO updatedSalaDTO = new SalaDTO(updatedSala.getId(),
                updatedSala.getKapacitet(), updatedSala.getOznaka());

        return new ResponseEntity<>(updatedSalaDTO, HttpStatus.OK);
    }
    //METODA ZA BRISANJE JEDNE SALE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteSala(@PathVariable Long id) {
        this.salaService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
