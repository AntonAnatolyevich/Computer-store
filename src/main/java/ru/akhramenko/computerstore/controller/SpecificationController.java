package ru.akhramenko.computerstore.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/specifications")
public class SpecificationController {

    @GetMapping("") //Также метод должен работать с фильтрами
    public String getAllSpecifications() {
        return null;
    }

    @GetMapping("/{id}")
    public String getSpecificationById() {
        return null;
    }

    @PostMapping("")
    public String addNewSpecification() {
        return null;
    }

    @PatchMapping("/{id}")
    public String updateSpecification() {
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteSpecificationById() {
        return null;
    }
}
