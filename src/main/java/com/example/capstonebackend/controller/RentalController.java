package com.example.capstonebackend.controller;

import com.example.capstonebackend.model.*;
import com.example.capstonebackend.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class RentalController {

    public List<Rental> findRentals(int customer_id) {
        List<Rental> rentals = rentalRepo.findAll();
        List <Rental> customerRentals = new ArrayList();
        for (Rental item : rentals) {
            if(item.getCustomer_id() == customer_id) {
                customerRentals.add(item);
            }
        }
        return customerRentals;
    }

    public Payment findPayment(Integer rental_id) {
        List<Payment> payments = paymentRepo.findAll();
        Payment payment = payments.stream().filter(item -> rental_id.equals(item.getRental_id())).findFirst().orElse(null);
        if(payment != null) {
            return payment;
        } else {
            return null;
        }
    }

    public Rental getRental(Integer id) {
        List<Rental> rentals = rentalRepo.findAll();
        Rental rental = rentals.stream().filter(item -> id.equals(item.getRental_id())).findFirst().orElse(null);
        return rental;
    }

    public CustomerRentals findCustomerRental(Integer rental_id) {
        List<CustomerRentals> rentals = customerRentalsRepo.findAll();
        CustomerRentals rental = rentals.stream().filter(item -> rental_id.equals(item.getRental_id())).findFirst().orElse(null);
        if(rental != null) {
            return rental;
        }else {
            return null;
        }
    }

    public Integer getInventoryId(Integer id) {
        List<Inventory> inventories = inventoryRepo.findAll();
        Inventory inventory = inventories.stream().filter(item -> id.equals(item.getFilm_id())).findFirst().orElse(null);
        return inventory.getInventory_id();
    }



    @Autowired
    RentalRepo rentalRepo;

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    CustomerRentalsRepo customerRentalsRepo;
    @Autowired
    InventoryRepo inventoryRepo;
    @Autowired
    FilmRepo filmRepo;

    @GetMapping("/getRentals")
    public List<Rental> getRentals() {
        return rentalRepo.findAll();
    }

    @DeleteMapping("/deleteRental/{id}")
    public void deleteRental(@PathVariable Integer id) {
        Payment payment = this.findPayment(id);
        CustomerRentals rental = this.findCustomerRental(id);
        if(payment != null) {
            paymentRepo.deleteById(payment.getPayment_id());
        }
        if(rental != null) {
            customerRentalsRepo.deleteById(rental.getRental_id());
        }
        if(id != null) {
            rentalRepo.deleteById(id);
        }
    }

    @GetMapping(value= "/customerRentals/{id}")
    public List<Rental> getCustomerRentals(@PathVariable Integer id) {
        return this.findRentals(id);
    }

    @PostMapping(value = "/addCustomerRental")
    public Rental addCustomerRental(@RequestBody Rental rental) {
        this.rentalRepo.save(rental);
        return rental;
    }
}
