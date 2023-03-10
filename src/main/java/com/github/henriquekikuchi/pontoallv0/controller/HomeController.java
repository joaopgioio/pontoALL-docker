package com.github.henriquekikuchi.pontoallv0.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@CrossOrigin
public class HomeController {

    @GetMapping
    public ResponseEntity<String> get(){
        
        return ResponseEntity.ok("PontoAll API v1.0");
    }
}