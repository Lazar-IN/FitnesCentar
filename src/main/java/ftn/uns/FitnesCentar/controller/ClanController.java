package ftn.uns.FitnesCentar.controller;

import ftn.uns.FitnesCentar.entity.Clan;
import ftn.uns.FitnesCentar.entity.dto.ClanDTO;
import ftn.uns.FitnesCentar.service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/clan")
public class ClanController {

    private final ClanService clanService;

    @Autowired
    public ClanController(ClanService clanService){
        this.clanService = clanService;
    }
    //METODA ZA DOBAVLJANJE JEDNOG CLANA
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO> getClan(@PathVariable("id") Long id){
        Clan clan = this.clanService.findOne(id);

        ClanDTO clanDTO = new ClanDTO();
        clanDTO.setKorisnickoIme(clan.getKorisnickoIme());
        clanDTO.setIme(clan.getIme());
        clanDTO.setPrezime(clan.getPrezime());
        clanDTO.setEmail(clan.getEmail());
        clanDTO.setKontaktTelefon(clan.getKontaktTelefon());
        clanDTO.setDatumRodjenja(clan.getDatumRodjenja());
        clanDTO.setUloga(clan.getUloga());
        clanDTO.setAktivan(clan.getAktivan());

        return new ResponseEntity<>(clanDTO, HttpStatus.OK);
    }
    //METODA ZA DOBAVLJANJE SVIH CLANOVA
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClanDTO>> getClans() {

        List<Clan> clanList = this.clanService.findAll();

        List<ClanDTO> clanDTOS = new ArrayList<>();

        for (Clan clan : clanList) {
            ClanDTO clanDTO = new ClanDTO(clan.getId(),clan.getKorisnickoIme(),
                    clan.getLozinka(),clan.getIme(),clan.getPrezime(),clan.getKontaktTelefon(),clan.getEmail(),
                    clan.getDatumRodjenja(),clan.getUloga(),clan.getAktivan());

            clanDTOS.add(clanDTO);
        }
        return new ResponseEntity<>(clanDTOS, HttpStatus.OK);
    }
    //METODA ZA KREIRANJE NOVOG CLANA
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO> createClan(@RequestBody ClanDTO clanDTO) throws Exception {

        Clan clan = new Clan(clanDTO.getKorisnickoIme(),clanDTO.getLozinka(),
                clanDTO.getIme(),clanDTO.getPrezime(),clanDTO.getKontaktTelefon(),clanDTO.getEmail(),
                clanDTO.getDatumRodjenja(),clanDTO.getUloga(),clanDTO.getAktivan());

        Clan newClan = clanService.save(clan);

        ClanDTO newClanDTO = new ClanDTO(newClan.getId(),newClan.getKorisnickoIme(),newClan.getLozinka(),
                newClan.getIme(),newClan.getPrezime(),newClan.getKontaktTelefon(),newClan.getEmail(),
                newClan.getDatumRodjenja(),newClan.getUloga(),newClan.getAktivan());

        return new ResponseEntity<>(newClanDTO, HttpStatus.CREATED);
    }
    //METODA ZA AZURIRANJE POSTOJECEG CLANA
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO> updateClan(@PathVariable Long id, @RequestBody ClanDTO clanDTO) throws Exception {

        Clan clan = new Clan(clanDTO.getKorisnickoIme(), clanDTO.getLozinka(),
                clanDTO.getIme(),clanDTO.getPrezime(),clanDTO.getKontaktTelefon(),clanDTO.getEmail(),
                clanDTO.getDatumRodjenja(),clanDTO.getUloga(),clanDTO.getAktivan());

        clan.setId(id);

        Clan updatedC = clanService.update(clan);

        ClanDTO updatedCDTO = new ClanDTO(updatedC.getId(),updatedC.getKorisnickoIme(),updatedC.getLozinka(),
                updatedC.getIme(),updatedC.getPrezime(),updatedC.getKontaktTelefon(),updatedC.getEmail(),
                updatedC.getDatumRodjenja(),updatedC.getUloga(),updatedC.getAktivan());

        return new ResponseEntity<>(updatedCDTO, HttpStatus.OK);
    }
    //METODA ZA BRISANJE JEDNOG CLANA
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteClan(@PathVariable Long id) {
        this.clanService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




/*
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/Clan")
    public ResponseEntity<PrijavaDTO> prijavaClan(@RequestBody PrijDTO dolazna) throws Exception {
        List<Clan> svi = clanService.findAll();
        PrijavaDTO prijavaDTO = new PrijavaDTO(dolazna.getKorisnickoIme(), dolazna.getLozinka(), 2, "",false);
        for (Clan clan : svi) {
            System.out.println(clan.getKorisnickoIme() + " : " + dolazna.getKorisnickoIme());
            System.out.println(clan.getLozinka() + " : " + dolazna.getLozinka());
            System.out.println("u: " + clan.getKorisnickoIme().equalsIgnoreCase(dolazna.getKorisnickoIme()));
            System.out.println("p: " + clan.getLozinka().equals(dolazna.getLozinka()));
            if (clan.getKorisnickoIme().equalsIgnoreCase(prijavaDTO.getKorisnickoIme()) && clan.getLozinka().equals(prijavaDTO.getLozinka())) {
                if (clan.getAktivan() == true) {
                    prijavaDTO.setPoruka("Uspešno ste se ulogovali!");
                    prijavaDTO.setId(clan.getId());
                    prijavaDTO.setAllert(false);
                    return new ResponseEntity<>(prijavaDTO, HttpStatus.OK);
                } else {
                    prijavaDTO.setPoruka("Član nije aktivan! ");
                    prijavaDTO.setAllert(true);
                    return new ResponseEntity<>(prijavaDTO, HttpStatus.OK);
                }
            } else {
                prijavaDTO.setPoruka("Uneli se pogrešnu šifru ili korisničko ime!");
                prijavaDTO.setAllert(true);

            }
        }
        return new ResponseEntity<>(prijavaDTO, HttpStatus.OK);
    }

 */

}
