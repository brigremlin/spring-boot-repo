package com.example.capstonebackend.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.swing.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name="rental")
public class Rental {

    @Id
    private Integer rental_id;
    private Timestamp rental_date;
    private Integer inventory_id;
    private short customer_id;
    private Timestamp return_date;
    private short staff_id;

    public Rental(Integer rental_id, Timestamp rental_date, Integer inventory_id, short customer_id, Timestamp return_date, short staff_id) {
        this.rental_id = rental_id;
        this.rental_date = rental_date;
        this.inventory_id = inventory_id;
        this.customer_id = customer_id;
        this.return_date = return_date;
        this.staff_id = staff_id;
    }

    public Rental() {

    }

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    public Timestamp getRental_date() {
        return rental_date;
    }

    public void setRental_date(Timestamp rental_date) {
        this.rental_date = rental_date;
    }

    public Integer getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public short getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(short customer_id) {
        this.customer_id = customer_id;
    }

    public Date getReturn_date() {
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
}
