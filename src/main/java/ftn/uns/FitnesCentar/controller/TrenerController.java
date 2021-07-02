package ftn.uns.FitnesCentar.controller;

import ftn.uns.FitnesCentar.entity.Trener;
import ftn.uns.FitnesCentar.entity.dto.TrenerDTO;
import ftn.uns.FitnesCentar.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/trener")
public class TrenerController {

    private final TrenerService trenerService;

    @Autowired
    public TrenerController(TrenerService trenerService){
        this.trenerService = trenerService;
    }
    //METODA ZA DOBAVLJANJE JEDNOG TRENERA
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> getTrener(@PathVariable("id") Long id){
        Trener trener = this.trenerService.findOne(id);

        TrenerDTO trenerDTO = new TrenerDTO();

        trenerDTO.setId(trener.getId());
        trenerDTO.setKorisnickoIme(trener.getKorisnickoIme());
        trenerDTO.setLozinka(trener.getLozinka());
        trenerDTO.setIme(trener.getIme());
        trenerDTO.setPrezime(trener.getPrezime());
        trenerDTO.setEmail(trener.getEmail());
        trenerDTO.setKontaktTelefon(trener.getKontaktTelefon());
        trenerDTO.setDatumRodjenja(trener.getDatumRodjenja());
        trenerDTO.setUloga(trener.getUloga());
        trenerDTO.setAktivan(trener.getAktivan());
        trenerDTO.setProsecnaOcena(trener.getProsecnaOcena());

        return new ResponseEntity<>(trenerDTO, HttpStatus.OK);
    }
    //METODA ZA DOBAVLJANJE SVIH TRENERA
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrenerDTO>> getTreners() {

        List<Trener> trenerList = this.trenerService.findAll();

        List<TrenerDTO> trenerDTOS = new ArrayList<>();

        for (Trener trener : trenerList) {
            TrenerDTO trenerDTO = new TrenerDTO(trener.getId(),trener.getKorisnickoIme(),
                    trener.getLozinka(),trener.getIme(),trener.getPrezime(),trener.getKontaktTelefon(),trener.getEmail(),
                    trener.getDatumRodjenja(),trener.getUloga(),trener.getAktivan(),
                    trener.getProsecnaOcena());

            trenerDTOS.add(trenerDTO);
        }
        return new ResponseEntity<>(trenerDTOS, HttpStatus.OK);
    }
    //METODA ZA KREIRANJE NOVOG TRENERA
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> createTrener(@RequestBody TrenerDTO trenerDTO) throws Exception {

        Trener trener = new Trener(trenerDTO.getId(), trenerDTO.getKorisnickoIme(),trenerDTO.getLozinka(),
                trenerDTO.getIme(),trenerDTO.getPrezime(),trenerDTO.getKontaktTelefon(),trenerDTO.getEmail(),
                trenerDTO.getDatumRodjenja(),trenerDTO.getUloga(),trenerDTO.getAktivan(),
                trenerDTO.getProsecnaOcena());

        Trener newTrener = trenerService.save(trener);

        TrenerDTO newTrenerDTO = new TrenerDTO(newTrener.getId(), newTrener.getKorisnickoIme(),newTrener.getLozinka(),
                newTrener.getIme(),newTrener.getPrezime(),newTrener.getKontaktTelefon(),newTrener.getEmail(),
                newTrener.getDatumRodjenja(),newTrener.getUloga(),newTrener.getAktivan(),
                newTrener.getProsecnaOcena());

        return new ResponseEntity<>(newTrenerDTO, HttpStatus.CREATED);
    }
    //METODA ZA AZURIRANJE POSTOJECEG TRENERA
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> updateTrener(@PathVariable Long id, @RequestBody TrenerDTO trenerDTO) throws Exception {

        Trener trener = new Trener(trenerDTO.getId(), trenerDTO.getKorisnickoIme(), trenerDTO.getLozinka(),
                trenerDTO.getIme(),trenerDTO.getPrezime(),trenerDTO.getKontaktTelefon(),trenerDTO.getEmail(),
                trenerDTO.getDatumRodjenja(),trenerDTO.getUloga(),trenerDTO.getAktivan(),
                trenerDTO.getProsecnaOcena());

        trener.setId(id);

        Trener updatedTrener = trenerService.update(trener);

        TrenerDTO updatedTrenerDTO = new TrenerDTO(updatedTrener.getId(), updatedTrener.getKorisnickoIme(),updatedTrener.getLozinka(),
                updatedTrener.getIme(),updatedTrener.getPrezime(),updatedTrener.getKontaktTelefon(),updatedTrener.getEmail(),
                updatedTrener.getDatumRodjenja(),updatedTrener.getUloga(),updatedTrener.getAktivan(),
                updatedTrener.getProsecnaOcena());

        return new ResponseEntity<>(updatedTrenerDTO, HttpStatus.OK);
    }
    //METODA ZA BRISANJE JEDNOG TRENERA
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteClan(@PathVariable Long id) {
        this.trenerService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //login
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "api/trener")


}
