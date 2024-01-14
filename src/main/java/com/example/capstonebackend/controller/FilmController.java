package com.example.capstonebackend.controller;

import com.example.capstonebackend.model.*;
import com.example.capstonebackend.repo.FilmRepo;
import com.example.capstonebackend.repo.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class FilmController {

    @Autowired
    FilmRepo filmRepo;
    @Autowired
    InventoryRepo inventoryRepo;

    public Film findFilmByID(Integer id) {
        List<Inventory> inventories = inventoryRepo.findAll();
        Inventory inventory = inventories.stream().filter(item -> id.equals(item.getInventory_id())).findFirst().orElse(null);
        if(inventory != null) {
            Integer inventory_id = inventory.getInventory_id();
            List<Film> films = filmRepo.findAll();
            Film film = films.stream().filter(item -> inventory_id.equals(item.getFilm_id())).findFirst().orElse(null);
            return film;
        }
        return null;
    }


    @GetMapping("/getAllFilms")
    public List<Film> getAllFilms() {
        return filmRepo.findAll();
    }

    @GetMapping("/getFilm/{id}")
    public Film getFilm(@PathVariable Integer id) {
        return this.findFilmByID(id);
    }

}