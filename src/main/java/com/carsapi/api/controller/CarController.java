package com.carsapi.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.carsapi.api.DTO.CarDTO;
import com.carsapi.api.model.Car;
import com.carsapi.api.repository.CarRepository;

import jakarta.validation.Valid;

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
    public void postCar(@RequestBody @Valid CarDTO req) {
        repository.save(new Car(req));
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateCar(@PathVariable Long id, @RequestBody @Valid CarDTO req) {
        repository.findById(id).map(car -> {
            car.setModelo(req.modelo());
            car.setFabricante(req.fabricante());
            car.setData_fabricacao(req.data_fabricacao());
            car.setValor(req.valor());
            car.setAno_modelo(req.ano_modelo());
            return repository.save(car);
        });
    }
        
}
