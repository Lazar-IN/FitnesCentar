package ftn.uns.FitnesCentar.controller;

import ftn.uns.FitnesCentar.entity.Trener;
import ftn.uns.FitnesCentar.entity.dto.TrenerLoginDTO;
import ftn.uns.FitnesCentar.service.TrenerLoginService;
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
@RequestMapping(value = "/api/trenerlogin")
public class TrenerLoginContoller {
    public final TrenerLoginService trenerLoginService;

    @Autowired
    public TrenerLoginContoller(TrenerLoginService trenerLoginService){
        this.trenerLoginService = trenerLoginService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerLoginDTO> getTrener(@RequestBody TrenerLoginDTO trenerLoginDTO){
        TrenerLoginDTO trenerDTO1 = new TrenerLoginDTO(trenerLoginDTO.getId(),
                trenerLoginDTO.getKorisnickoIme(), trenerLoginDTO.getLozinka());
        List<Trener> trenerList = this.trenerLoginService.findAll();

        for(Trener trener : trenerList){
            if (trener.getKorisnickoIme().equals(trenerDTO1.getKorisnickoIme())){
                if(trener.getLozinka().equals(trenerDTO1.getLozinka())){
                    trenerDTO1.setId(trener.getId());
                    return new ResponseEntity<>(trenerDTO1, HttpStatus.OK);
                } else{
                    return new ResponseEntity<>(trenerDTO1, HttpStatus.BAD_REQUEST);
                }
            }
        }
        return new ResponseEntity<>(trenerDTO1, HttpStatus.NOT_FOUND);
    }


}