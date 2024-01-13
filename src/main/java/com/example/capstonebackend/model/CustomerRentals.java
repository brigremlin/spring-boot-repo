package com.example.capstonebackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="customer_rentals")
public class CustomerRentals {


    private Integer customer_id;
    private String first_name;
    private String last_name;
    @Id
    private Integer rental_id;
    Timestamp rental_date;
    private Timestamp return_date;
    private short staff_id;
    private Integer payment_id;
    private Float amount;

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getRental_id() {
        return rental_id;
    }

    public void setRental_id(Integer rental_id) {
        this.rental_id = rental_id;
    }

    public Timestamp getRental_date() {
        return rental_date;
    }

    public void setRental_date(Timestamp rental_date) {
        this.rental_date = rental_date;
    }

    public Timestamp getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Timestamp return_date) {
        this.return_date = return_date;
    }

    public short getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(short staff_id) {
        this.staff_id = staff_id;
    }

    public Integer getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Integer payment_id) {
        this.payment_id = payment_id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
