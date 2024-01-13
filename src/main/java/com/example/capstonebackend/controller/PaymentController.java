package com.example.capstonebackend.controller;
import com.example.capstonebackend.model.Film;
import com.example.capstonebackend.model.Payment;
import com.example.capstonebackend.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://video-rush-front-end.web.app/")
@RestController
public class PaymentController {

    public Payment findPayment(Integer rental_id) {
        List<Payment> payments = paymentRepo.findAll();
        Payment payment = payments.stream().filter(item -> rental_id.equals(item.getRental_id())).findFirst().orElse(null);
        return payment;
    }

    @Autowired
    PaymentRepo paymentRepo;

    @GetMapping("/findPayment/{id}")
    public Payment findPaymentByRentalID(@PathVariable Integer id) {
        return this.findPayment(id);
    }

    @PostMapping(value = "/postPayment")
    public Payment postPayment(@RequestBody Payment payment) {
        this.paymentRepo.save(payment);
        return payment;
    }

}
