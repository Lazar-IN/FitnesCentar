package ftn.uns.FitnesCentar.controller;

import ftn.uns.FitnesCentar.entity.Trening;
import ftn.uns.FitnesCentar.entity.dto.TreningDTO;
import ftn.uns.FitnesCentar.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/trening" +
        "")
public class TreningController {

    private final TreningService treningService;

    @Autowired
    public TreningController(TreningService treningService){
        this.treningService = treningService;
    }
    //METODA ZA DOBAVLJANJE JEDNOG TRENINGA
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> getTrening(@PathVariable("id") Long id){
        Trening trening = this.treningService.findOne(id);

        TreningDTO treiningDTO = new TreningDTO();
        treiningDTO.setId(trening.getId());
        treiningDTO.setNaziv(trening.getNaziv());
        treiningDTO.setNivoTreninga(trening.getNivoTreninga());
        treiningDTO.setTipTreninga(trening.getTipTreninga());
        treiningDTO.setOpis(trening.getOpis());
        treiningDTO.setDanaUNedelji(trening.getDanaUNedelji());
        treiningDTO.setTrajanjeUNedeljama(trening.getTrajanjeUNedeljama());

        return new ResponseEntity<>(treiningDTO, HttpStatus.OK);

    }
    //METODA ZA DOBAVLJANJE SVIH TRENINGA
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> getTrenings() {

        List<Trening> treningList = this.treningService.findAll();

        List<TreningDTO> treningDTOS = new ArrayList<>();

        for (Trening trening : treningList) {
            TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
                    trening.getNivoTreninga(),trening.getDanaUNedelji(),
                    trening.getTrajanjeUNedeljama(),trening.getTipTreninga(),
                    trening.getOpis());

            treningDTOS.add(treningDTO);
        }
        return new ResponseEntity<>(treningDTOS, HttpStatus.OK);
    }
    //METODA ZA DOBAVLJANJE SVIH TRENINGA OD JEDNOG TRENERA
    @GetMapping(value = "/odTrenera/{trenerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> getTreningeId(@PathVariable("trenerId") Long trenerId) {
        List<Trening> treningList = this.treningService.findByTrenerId(trenerId);

        List<TreningDTO> treningDTOS = new ArrayList<>();

        for(Trening trening: treningList) {
            TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(), trening.getNivoTreninga(),
                    trening.getTrajanjeUNedeljama(), trening.getDanaUNedelji(), trening.getTipTreninga(), trening.getOpis());
            treningDTOS.add(treningDTO);
        }

        return new ResponseEntity<>(treningDTOS, HttpStatus.OK);
    }


    //METODA ZA KREIRANJE NOVOG TRENINGA
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> createTrening(@RequestBody TreningDTO treningDTO) throws Exception {

        Trening trening = new Trening(treningDTO.getId(), treningDTO.getNaziv(),
                treningDTO.getNivoTreninga(),treningDTO.getDanaUNedelji(),
                treningDTO.getTrajanjeUNedeljama(),treningDTO.getTipTreninga(),
                treningDTO.getOpis());
        ////////////////////////////////////paziti ovde///////////////////////////
        trening.setTrener(treningDTO.getTrenerId());
        ////////////////////////////////////paziti ovde///////////////////////////
        Trening newTrening = treningService.save(trening);

        TreningDTO newTreningDTO = new TreningDTO(newTrening.getId(), newTrening.getNaziv(),
                newTrening.getNivoTreninga(),newTrening.getDanaUNedelji(),
                newTrening.getTrajanjeUNedeljama(),newTrening.getTipTreninga(),
                newTrening.getOpis(), treningDTO.getTrenerId());

        return new ResponseEntity<>(newTreningDTO, HttpStatus.CREATED);
    }
    //METODA ZA AZURIRANJE POSTOJECEG TRENINGA
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> updateTrening(@PathVariable Long id, @RequestBody TreningDTO treningDTO) throws Exception {

        Trening trening = new Trening(treningDTO.getId(), treningDTO.getNaziv(),
                treningDTO.getNivoTreninga(),treningDTO.getDanaUNedelji(),
                treningDTO.getTrajanjeUNedeljama(),treningDTO.getTipTreninga(),
                treningDTO.getOpis());

        trening.setId(id);

        Trening updatedTr = treningService.update(trening);

        TreningDTO updatedTrDTO = new TreningDTO(updatedTr.getId(), updatedTr.getNaziv(),
                updatedTr.getNivoTreninga(),updatedTr.getDanaUNedelji(),
                updatedTr.getTrajanjeUNedeljama(),updatedTr.getTipTreninga(),
                updatedTr.getOpis());

        return new ResponseEntity<>(updatedTrDTO, HttpStatus.OK);
    }
    //METODA ZA BRISANJE JEDNOG TRENINGA
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTrening(@PathVariable Long id) {
        this.treningService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
