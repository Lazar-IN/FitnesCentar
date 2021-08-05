package ftn.uns.FitnesCentar.controller;

import ftn.uns.FitnesCentar.entity.Clan;
import ftn.uns.FitnesCentar.entity.dto.ClanDTO;
import ftn.uns.FitnesCentar.entity.dto.ClanLoginDTO;
import ftn.uns.FitnesCentar.service.ClanLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/clanlogin")
public class ClanLoginContoller {
    public final ClanLoginService clanLoginService;

    @Autowired
    public ClanLoginContoller(ClanLoginService clanLoginService){
        this.clanLoginService = clanLoginService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanLoginDTO> getClan(@RequestBody ClanLoginDTO clanLoginDTO){
        ClanLoginDTO clanDTO1 = new ClanLoginDTO(clanLoginDTO.getId(),
                clanLoginDTO.getKorisnickoIme(), clanLoginDTO.getLozinka());
        List<Clan> clanList = this.clanLoginService.findAll();

        for(Clan clan : clanList){
            if (clan.getKorisnickoIme().equals(clanDTO1.getKorisnickoIme())){
                if(clan.getLozinka().equals(clanDTO1.getLozinka())){
                    clanDTO1.setId(clan.getId());
                    return new ResponseEntity<>(clanDTO1, HttpStatus.OK);
                } else{
                    return new ResponseEntity<>(clanDTO1, HttpStatus.BAD_REQUEST);
                }
            }
        }
        return new ResponseEntity<>(clanDTO1, HttpStatus.NOT_FOUND);
    }
}



