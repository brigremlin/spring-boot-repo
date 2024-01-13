package com.example.capstonebackend.repo;
import com.example.capstonebackend.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "")
@RepositoryRestResource
public interface PaymentRepo extends JpaRepository<Payment, Integer> {
}
