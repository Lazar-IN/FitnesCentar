package ftn.uns.FitnesCentar.controller;

import ftn.uns.FitnesCentar.entity.Admin;
import ftn.uns.FitnesCentar.entity.dto.AdminLoginDTO;
import ftn.uns.FitnesCentar.service.AdminLoginService;
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
@RequestMapping(value = "/api/adminlogin")
public class AdminLoginContoller {
    public final AdminLoginService adminLoginService;

    @Autowired
    public AdminLoginContoller(AdminLoginService adminLoginService){
        this.adminLoginService = adminLoginService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminLoginDTO> getAdmin(@RequestBody AdminLoginDTO adminDTO){
        AdminLoginDTO adminDTO1 = new AdminLoginDTO(adminDTO.getId(), adminDTO.getKorisnickoIme(), adminDTO.getLozinka());
        List<Admin> adminList = this.adminLoginService.findAll();

        for(Admin admin : adminList){
            if (admin.getKorisnickoIme().equals(adminDTO1.getKorisnickoIme())){
                if(admin.getLozinka().equals(adminDTO1.getLozinka())){
                    adminDTO1.setId(admin.getId());
                    return new ResponseEntity<>(adminDTO1, HttpStatus.OK);
                } else{
                    return new ResponseEntity<>(adminDTO1, HttpStatus.BAD_REQUEST);
                }
            }
        }
        return new ResponseEntity<>(adminDTO1, HttpStatus.NOT_FOUND);
    }


}
