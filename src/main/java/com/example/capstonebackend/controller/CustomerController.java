package com.example.capstonebackend.controller;

import com.example.capstonebackend.model.Customer;
import com.example.capstonebackend.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CustomerController {

    public Customer findCustomer(Integer customer_id) {
        List<Customer> customers = customerRepo.findAll();
        Customer customer = customers.stream().filter(item -> customer_id.equals(item.getCustomer_id())).findFirst().orElse(null);
        return customer;
    }

    public void updateExistingCustomer(Customer customer) {
        Customer newCustomer = findCustomer(customer.getCustomer_id());
        System.out.println(newCustomer);
        if(newCustomer != null) {
            newCustomer.setFirst_name(customer.getFirst_name());
            newCustomer.setLast_name(customer.getLast_name());
            newCustomer.setEmail(customer.getEmail());
            newCustomer.setActive(customer.getActive());
            newCustomer.setActivebool(customer.isActivebool());
            customerRepo.save(newCustomer);
        }
    }

    @Autowired
    CustomerRepo customerRepo;

    @PostMapping(value = "/addCustomer")
    public void addCustomer(@RequestBody Customer customer) {
        System.out.println(customer.getCustomer_id());
        customerRepo.save(customer);
    }

    @GetMapping("/getCustomers")
    public List<Customer> getCustomers() {
        return customerRepo.findAll();
    }

    @GetMapping("/findCustomer/{id}")
    public Customer findCustomerByID(@PathVariable Integer id) {
        return this.findCustomer(id);
    }

    @PostMapping("/updateCustomer")
    public void updateCustomer(@RequestBody Customer customer) {
        this.updateExistingCustomer(customer);
    }

}
