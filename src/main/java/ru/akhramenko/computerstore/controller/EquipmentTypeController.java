package ru.akhramenko.computerstore.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/equipment-types")
public class EquipmentTypeController {

    @GetMapping("")
    public String getAllEquipmentTypes() {
        return null;
    }

    @GetMapping("/{id}")
    public String getEquipmentTypeById() {
        return null;
    }

    @GetMapping("/{id}/equipments")
    public String getEquipmentTypeByIdWithEquipments() {
        return null;
    }

    @PostMapping("")
    public String addNewEquipmentType() {
        return null;
    }

    @PatchMapping("/{id}")
    public String updateEquipmentType() {
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteEquipmentTypeById() {
        return null;
    }
}
