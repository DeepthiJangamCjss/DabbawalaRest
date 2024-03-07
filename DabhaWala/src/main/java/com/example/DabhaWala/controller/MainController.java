package com.example.DabhaWala.controller;

import com.example.DabhaWala.entity.Location;
import com.example.DabhaWala.models.CustomerModel;
import com.example.DabhaWala.models.LocationModel;
import com.example.DabhaWala.service.AdminService;
import com.example.DabhaWala.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class MainController{
    @Autowired
    private AdminService adminService;
    @GetMapping("/")
    public String homePage(){
        return "home";
    }

    @GetMapping("/viewLocations")
    public List<LocationModel> getAllLocations(){
        return adminService.getAllLocations();
    }

    @PostMapping("/addLocation")
    public String addLocation(@RequestBody LocationModel locationModel){
        return adminService.addLocation(locationModel);
    }
}