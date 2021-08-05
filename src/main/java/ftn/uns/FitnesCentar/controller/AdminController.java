package ftn.uns.FitnesCentar.controller;

import ftn.uns.FitnesCentar.entity.Admin;
import ftn.uns.FitnesCentar.entity.dto.AdminDTO;
import ftn.uns.FitnesCentar.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }
    //METODA ZA DOBAVLJANJE JEDNOG ADMINA
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminDTO> getAdmin(@PathVariable("id") Long id){
        Admin admin = this.adminService.findOne(id);

        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setId(admin.getId());
        adminDTO.setKorisnickoIme(admin.getKorisnickoIme());
        adminDTO.setLozinka(admin.getLozinka());
        adminDTO.setIme(admin.getIme());
        adminDTO.setPrezime(admin.getPrezime());
        adminDTO.setEmail(admin.getEmail());
        adminDTO.setKontaktTelefon(admin.getKontaktTelefon());
        adminDTO.setDatumRodjenja(admin.getDatumRodjenja());
        adminDTO.setUloga(admin.getUloga());
        adminDTO.setAktivan(admin.getAktivan());

        return new ResponseEntity<>(adminDTO, HttpStatus.OK);
    }
    //METODA ZA DOBAVLJANJE SVIH ADMINA
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AdminDTO>> getAdmins() {

        List<Admin> adminList = this.adminService.findAll();

        List<AdminDTO> adminDTOS = new ArrayList<>();

        for (Admin admin : adminList) {
            AdminDTO adminDTO = new AdminDTO(admin.getId(),admin.getKorisnickoIme(),admin.getLozinka()
                    ,admin.getIme(),admin.getPrezime(),admin.getKontaktTelefon(),admin.getEmail(),
                    admin.getDatumRodjenja(),admin.getUloga(),admin.getAktivan());

            adminDTOS.add(adminDTO);
        }
        return new ResponseEntity<>(adminDTOS, HttpStatus.OK);
    }

    /*
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/Admin")
    public ResponseEntity<PrijavaDTO> prijavaAdmin(@RequestBody PrijDTO dolazna) throws Exception {
        List<Admin> svi = adminService.findAll();
        PrijavaDTO prijavaDTO = new PrijavaDTO(dolazna.getKorisnickoIme(), dolazna.getLozinka(), 1, "", false);
        for (Admin admin : svi) {
            if (admin.getKorisnickoIme().equalsIgnoreCase(prijavaDTO.getKorisnickoIme()) && admin.getLozinka().equals(prijavaDTO.getLozinka())) {
                if (admin.getAktivan() == true) {
                    prijavaDTO.setPoruka("Uspešno ste se ulogovali!");
                    prijavaDTO.setId(admin.getId());
                    prijavaDTO.setAllert(false);
                    return new ResponseEntity<>(prijavaDTO, HttpStatus.OK);
                } else {
                    prijavaDTO.setPoruka("Administartor nije aktivan! ");
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

