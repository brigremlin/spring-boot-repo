package com.example.capstonebackend.controller;

import com.example.capstonebackend.model.*;
import com.example.capstonebackend.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class RentalDetailsController {

    public List<RentalDetails> customerRentalsByStore(short id) {
        List<RentalDetails> rentals = rentalDetailsRepo.findAll();
        List<RentalDetails> returnedRentals = new ArrayList<>();
        for ( RentalDetails rental : rentals) {
            if(rental.getStore_id() == id) {
                returnedRentals.add(rental);
            }
        }
        return returnedRentals;
    }

    public Short getFilmId(Integer id) {
        List<Inventory> inventories = inventoryRepo.findAll();
        Inventory inventory = inventories.stream().filter(item -> id.equals(item.getInventory_id())).findFirst().orElse(null);
        return inventory.getFilm_id();
    }

    public short getCategoryId(Short id) {
        short returnedCategory = 0;
        List<FilmCategory> filmCategories = filmCategoryRepo.findAll();
        for ( FilmCategory filmCategory : filmCategories ) {
            if(id.equals(filmCategory.getFilm_id())) {
                returnedCategory = filmCategory.getCategory_id();
            }
        }
        return returnedCategory;
    }

    public Category getCategory(Short id) {
        Integer new_id = Integer.valueOf(id);
        List<Category>categories = categoryRepo.findAll();
        Category category = categories.stream().filter(item -> new_id.equals(item.getCategory_id())).findFirst().orElse(null);
        return category;
    }

    public Rental getRental(Integer id) {
        List<Rental> rentals = rentalRepo.findAll();
        Rental rental = rentals.stream().filter(item -> id.equals(item.getRental_id())).findFirst().orElse(null);
        return rental;
    }

    public Category getAllRentals(Integer id) {
        Rental rental = this.getRental(id);
        Integer inventory_id = rental.getInventory_id();
        Short film_id = this.getFilmId(inventory_id);
        short category_id = this.getCategoryId(film_id);
        Category category = this.getCategory(category_id);
        return category;
    }

    @Autowired
    RentalDetailsRepo rentalDetailsRepo;

    @Autowired
    InventoryRepo inventoryRepo;

    @Autowired
    FilmCategoryRepo filmCategoryRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    RentalRepo rentalRepo;

    @GetMapping("/getRentalDetails")
    public List<RentalDetails> getAllRentalDetails() {
        return rentalDetailsRepo.findAll();
    }

    @GetMapping("/getRentalsByStore/{id}")
    public List<RentalDetails> getRentalsByStore(@PathVariable short id) {
        return this.customerRentalsByStore(id);
    }

    @GetMapping("/getCategory/{id}")
    public Category getCategory(@PathVariable Integer id) {
        return this.getAllRentals(id);
    }
}
