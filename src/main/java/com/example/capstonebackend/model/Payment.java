package com.example.capstonebackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name="payment")
public class Payment {

    @Id
    private Integer payment_id;

    public Integer getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Integer payment_id) {
        this.payment_id = payment_id;
    }

    public short getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(short customer_id) {
        this.customer_id = customer_id;
    }

    public short getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(short staff_id) {
        this.staff_id = staff_id;
    }

    public Integer getRental_id() {
        return rental_id;
    }

    public void setRental_id(Integer rental_id) {
        this.rental_id = rental_id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Timestamp getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Timestamp payment_date) {
        this.payment_date = payment_date;
    }

    private short customer_id;
    private short staff_id;
    private Integer rental_id;
    private float amount;
    private Timestamp payment_date;
}
