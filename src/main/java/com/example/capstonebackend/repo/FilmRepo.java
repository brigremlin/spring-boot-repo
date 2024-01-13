package com.example.capstonebackend.repo;
import com.example.capstonebackend.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "")
@RepositoryRestResource
public interface FilmRepo extends JpaRepository<Film, Integer> {

//    List<Film> findByFilm_id(Integer film_id);
}
