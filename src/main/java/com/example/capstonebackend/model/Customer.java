package com.example.capstonebackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="customer")
public class Customer {

    @Id
    protected Integer customer_id;
    private short store_id;
    protected String first_name;
    protected String last_name;
    private String email;
    private short address_id;
    private boolean activebool;
    private int active;

    public Customer() {

    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(short store_id) {
        this.store_id = store_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(short address_id) {
        this.address_id = address_id;
    }

    public boolean isActivebool() {
        return activebool;
    }

    public void setActivebool(boolean activebool) {
        this.activebool = activebool;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Customer(Integer customer_id, short store_id, String first_name, String last_name, String email, short address_id, boolean activebool, int active) {
        this.customer_id = customer_id;
        this.store_id = store_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.address_id = address_id;
        this.activebool = activebool;
        this.active = active;
    }
}
