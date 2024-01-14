package com.example.capstonebackend.controller;

import com.example.capstonebackend.model.CustomerRentals;
import com.example.capstonebackend.repo.CustomerRentalsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class CustomerRentalsController {

    public List<CustomerRentals> customerRentals(Integer id) {
        List<CustomerRentals> rentals = customerRentalsRepo.findAll();
        List<CustomerRentals> returnedRentals = new ArrayList<>();
        for ( CustomerRentals rental : rentals) {
            if(rental.getCustomer_id().equals(id)) {
                returnedRentals.add(rental);
            }
        }
        return returnedRentals;
    }

    @Autowired
    CustomerRentalsRepo customerRentalsRepo;

    @GetMapping("/getCustomerRentals")
    public List<CustomerRentals> getAllCustomerRentals() {
        return customerRentalsRepo.findAll();
    }

    @GetMapping("/getRentalsByCustomer/{id}")
    public List<CustomerRentals> getRentalsByCustomer(@PathVariable Integer id) {
        return this.customerRentals(id);
    }

    @PostMapping(value = "/postCustomerRental")
    public CustomerRentals postCustomerRental(@RequestBody CustomerRentals customerRentals) {
        this.customerRentalsRepo.save(customerRentals);
        return customerRentals;
    }

}
