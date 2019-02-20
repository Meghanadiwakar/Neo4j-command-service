package com.stackroute.graph.controller;


import com.stackroute.graph.model.User;
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


    @PostMapping("/adduser")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        ResponseEntity<String> responseEntity;
        try {
            homeService.saveUserToDb(user);
            responseEntity = new ResponseEntity<>("User saved sucessfully", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>("Error occured while saving", HttpStatus.BAD_GATEWAY);
        }
        return responseEntity;
    }

    @GetMapping("/getusers")
    public ResponseEntity<Collection<User>> getAllUsers() {
        ResponseEntity<Collection<User>> responseEntity;
        try {
            log.info("Fetching user nodes");
            responseEntity = new ResponseEntity(homeService.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity(Collections.emptyList(), HttpStatus.BAD_GATEWAY);
        }
        return responseEntity;
    }




}
