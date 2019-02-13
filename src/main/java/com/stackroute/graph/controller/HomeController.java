package com.stackroute.graph.controller;

import com.stackroute.graph.model.Movie;
import com.stackroute.graph.model.Person;
import com.stackroute.graph.service.HomeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
public class HomeController {
    private HomeService homeService;

    HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        ResponseEntity<List<Movie>> responseEntity;
        List<Movie> movies;
        //String movies="sdv";
        try {
            log.info("Fetching movie nodes");
            movies = IteratorUtils.toList(homeService.getAllMovies().iterator());

            responseEntity = new ResponseEntity(movies, HttpStatus.OK);


        } catch (Exception e) {
            e.printStackTrace();
            movies = Collections.emptyList();
            responseEntity = new ResponseEntity(movies, HttpStatus.BAD_GATEWAY);

        }
        return responseEntity;
    }

    @PostMapping("/addmovie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        ResponseEntity<String> responseEntity;
        try {
            homeService.saveMovieToDb(movie);
            responseEntity = new ResponseEntity<>("Movie saved sucessfully", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>("Error occured while saving", HttpStatus.BAD_GATEWAY);
        }
        return responseEntity;
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        ResponseEntity<List<Person>> responseEntity;
        List<Person> movies;
        try {
            log.info("Fetching person nodes");
            movies = IteratorUtils.toList(homeService.getAllPersons().iterator());
            responseEntity = new ResponseEntity(movies, HttpStatus.OK);


        } catch (Exception e) {
            e.printStackTrace();
            movies = Collections.emptyList();
            responseEntity = new ResponseEntity(movies, HttpStatus.BAD_GATEWAY);

        }
        return responseEntity;
    }

    @PostMapping("/addperson")
    public ResponseEntity<String> addPerson(@RequestBody Person person) {
        ResponseEntity<String> responseEntity;
        try {
            homeService.savePersonToDb(person);
            responseEntity = new ResponseEntity<>("Person saved sucessfully", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>("Error occured while saving", HttpStatus.BAD_GATEWAY);
        }
        return responseEntity;
    }

    @DeleteMapping("/deleteperson")
    public ResponseEntity<String> deleteallPersons() {
        ResponseEntity<String> responseEntity;
        try {
            homeService.deletePersons();
            responseEntity = new ResponseEntity<>("Person deleted    sucessfully", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>("Error occured while deleting", HttpStatus.BAD_GATEWAY);
        }
        return responseEntity;
    }

    @DeleteMapping("/deletemovie")
    public ResponseEntity<String> deleteallMovies() {
        ResponseEntity<String> responseEntity;
        try {
            homeService.deleteMovies();
            responseEntity = new ResponseEntity<>("Movie deleted    sucessfully", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>("Error occured while deleting", HttpStatus.BAD_GATEWAY);
        }
        return responseEntity;
    }


}
