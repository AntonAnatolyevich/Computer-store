package ru.akhramenko.computerstore.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/equipments")
public class EquipmentController {

    @GetMapping("")
    public String getAllEquipment() {
        return null;
    }

    @GetMapping("/{id}")
    public String getEquipmentById() {
        return null;
    }

    @PostMapping("")
    public String addNewEquipment() { return null; }

    @PatchMapping("/{id}")
    public String updateEquipment() {
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteEquipmentById() {
        return null;
    }

    @PostMapping("/id/specifications")
    public String addNewEquipSpec() {
        return null;
    }

    @PutMapping("/{id}/specifications")
    public String updateEquipSpec() {
        return null;
    }

    @DeleteMapping("/{id}/specifications")
    public String deleteEquipSpecById() {
        return null;
    }
}
