package com.carsapi.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.carsapi.api.DTO.CarDTO;
import com.carsapi.api.model.Car;
import com.carsapi.api.repository.CarRepository;

@RestController
@RequestMapping(value="/api/cars")

public class CarController {

    @Autowired
    private CarRepository repository;

    @GetMapping
    public List<Car> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public void postCar(@RequestBody CarDTO req) {
        repository.save(new Car(req));
    }
        
}
