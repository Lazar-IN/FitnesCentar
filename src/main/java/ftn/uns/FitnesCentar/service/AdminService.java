package ftn.uns.FitnesCentar.service;

import ftn.uns.FitnesCentar.entity.Admin;
import ftn.uns.FitnesCentar.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin findOne(Long id){
        Admin admin = this.adminRepository.getOne(id);

        return admin;
    }

    public List<Admin> findAll() {
        List<Admin> admins = this.adminRepository.findAll();

        return  admins;
    }

    public Admin save(Admin admin){
        return this.adminRepository.save(admin);
    }

    public Admin update(Admin admin) throws Exception{
        Admin adminToUpDate = this.adminRepository.getOne(admin.getId());

        if (adminToUpDate == null){
            throw new Exception("Admin ne postoji!");
        }

        adminToUpDate.setKorisnickoIme(admin.getKorisnickoIme());
        adminToUpDate.setIme(admin.getIme());
        adminToUpDate.setPrezime(admin.getPrezime());
        adminToUpDate.setDatumRodjenja(admin.getDatumRodjenja());
        adminToUpDate.setEmail(admin.getEmail());
        adminToUpDate.setUloga(admin.getUloga());
        adminToUpDate.setAktivan(admin.getAktivan());

        Admin savedAd = this.adminRepository.save(adminToUpDate);

        return savedAd;
    }


}
