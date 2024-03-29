package com.example.capstonebackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="film")
public class Film {

    @Id
    Integer film_id;
    private String title;
    private String description;
    private Integer release_year;
    private short language_id;
    private short rental_duration;
    private float rental_rate;
    private short length;
    private float replacement_cost;
    private String rating;

    public Integer getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Integer film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Integer release_year) {
        this.release_year = release_year;
    }

    public short getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(short language_id) {
        this.language_id = language_id;
    }

    public short getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(short rental_duration) {
        this.rental_duration = rental_duration;
    }

    public float getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(float rental_rate) {
        this.rental_rate = rental_rate;
    }

    public short getLength() {
        return length;
    }

    public void setLength(short length) {
        this.length = length;
    }

    public float getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(float replacement_cost) {
        this.replacement_cost = replacement_cost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


}
