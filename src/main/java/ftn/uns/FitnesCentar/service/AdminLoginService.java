package ftn.uns.FitnesCentar.service;

import ftn.uns.FitnesCentar.entity.Admin;
import ftn.uns.FitnesCentar.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminLoginService {
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
}
