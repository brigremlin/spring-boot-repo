package com.example.capstonebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="inventory")
public class Inventory {

    @Id
    private Integer inventory_id;
    private short film_id;
    private short store_id;


    public Integer getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(Integer inventory_id) {
        this.inventory_id = inventory_id;
    }

    public short getFilm_id() {
        return film_id;
    }

    public void setFilm_id(short film_id) {
        this.film_id = film_id;
    }

    public short getStore_id() {
        return store_id;
    }

    public void setStore_id(short store_id) {
        this.store_id = store_id;
    }
}
