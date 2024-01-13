package com.example.capstonebackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="film_category")
public class FilmCategory {

    @Id
    short film_id;
    private short category_id;

    public short getCategory_id() {
        return category_id;
    }

    public void setCategory_id(short category_id) {
        this.category_id = category_id;
    }

    public short getFilm_id() {
        return film_id;
    }

    public void setFilm_id(short film_id) {
        this.film_id = film_id;
    }
}
