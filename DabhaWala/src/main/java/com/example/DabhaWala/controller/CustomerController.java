package com.example.DabhaWala.controller;

import com.example.DabhaWala.models.CustomerModel;
import com.example.DabhaWala.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/register")
    public String customerRegister(@RequestBody @Valid CustomerModel customerModel){
        return customerService.addCustomer(customerModel);
    }

    @GetMapping("/getCustomerDetails/{customerId}")
    public CustomerModel getCustomerDetails(@PathVariable("customerId") int customerId) {
        return customerService.getCustomerDetails(customerId);
    }

}
