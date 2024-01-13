package com.example.capstonebackend.controller;
import com.example.capstonebackend.repo.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://video-rush-front-end.web.app/")
@RestController

public class FilmCategoryController{
    @Autowired
    FilmRepo filmRepo;


}
