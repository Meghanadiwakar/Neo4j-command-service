package com.stackroute.graph.controller;

import com.stackroute.graph.model.Movie;
import com.stackroute.graph.model.Person;
import com.stackroute.graph.service.HomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@Slf4j
public class HomeController {
    private HomeService homeService;

    HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/getallmovies")
    public ResponseEntity<Collection<Movie>> getAllMovies() {
        ResponseEntity<Collection<Movie>> responseEntity;
        try {
            log.info("Fetching movie nodes");
            responseEntity = new ResponseEntity(homeService.getMovies(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity(Collections.emptyList(), HttpStatus.BAD_GATEWAY);
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


    @GetMapping("/getallpersons")
    public ResponseEntity<Collection<Person>> getAllPersons() {
        ResponseEntity<Collection<Person>> responseEntity;
        try {
            log.info("Fetching person nodes");

            responseEntity = new ResponseEntity(homeService.getPersons(), HttpStatus.OK);


        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity(Collections.emptyList(), HttpStatus.BAD_GATEWAY);

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

//    @GetMapping("/movie")
//    public Collection<Movie> getMovies() { return homeService.getMovies();}
//
//
//    @GetMapping("/person")
//    public Collection<Person> getPersons() { return homeService.getPersons();}

    @DeleteMapping("/deleteperson/{name}")
    public ResponseEntity<?> deleteallPersons(@PathVariable("name") String name) {
        ResponseEntity<?> responseEntity;
        try {
            homeService.deletePersons(name);
            responseEntity = new ResponseEntity<>("Person deleted sucessfully", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>("Error occured while deleting", HttpStatus.BAD_GATEWAY);
        }
        return responseEntity;
    }

    @DeleteMapping("/deletemovie/{released}")
    public ResponseEntity<?> deleteallMovies(@PathVariable("released") int released) {
        ResponseEntity<String> responseEntity;
        try {
            homeService.deleteMovies(released);
            responseEntity = new ResponseEntity<>("Person deleted sucessfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>("Error occured while deleting", HttpStatus.BAD_GATEWAY);
        }
        return responseEntity;
    }
}
