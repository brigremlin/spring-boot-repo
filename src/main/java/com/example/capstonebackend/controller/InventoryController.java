package com.example.capstonebackend.controller;
import com.example.capstonebackend.model.Inventory;
import com.example.capstonebackend.repo.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://video-rush-front-end.web.app/")
@RestController
public class InventoryController {

    @Autowired
    InventoryRepo inventoryRepo;

    public Integer getInventoryId(Integer film_id) {
        Integer id = null;
        System.out.println("film: " + film_id);
        List<Inventory> inventories = inventoryRepo.findAll();
        for (Inventory inventory : inventories) {
            if(film_id == inventory.getFilm_id()) {
                id = inventory.getInventory_id();
            }
        }
        return id;
    }

    @GetMapping("/getInventoryId/{id}")
    public Integer getId(@PathVariable Integer id) {
        return this.getInventoryId(id);
    }

    @GetMapping("/getInventory")
    public List<Inventory> getInventory() {
        return inventoryRepo.findAll();
    }
}
