package ftn.uns.FitnesCentar.controller;

import ftn.uns.FitnesCentar.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
}
