package com.carsapi.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.carsapi.api.DTO.CarDTO;

@RestController
@RequestMapping

public class CarController {
    @PostMapping(value="/api/cars")
    public void postCar(@RequestBody CarDTO req) {
        System.out.println(req);
    }
        
}
