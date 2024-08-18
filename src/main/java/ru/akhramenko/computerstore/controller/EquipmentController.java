package ru.akhramenko.computerstore.controller;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.akhramenko.computerstore.dto.equipment.EquipmentRequest;
import ru.akhramenko.computerstore.dto.equipment.EquipmentResponse;
import ru.akhramenko.computerstore.dto.equipmentspecification.EquipmentSpecificationRequest;
import ru.akhramenko.computerstore.dto.equipmentspecification.EquipmentSpecificationResponse;
import ru.akhramenko.computerstore.service.EquipmentService;
import ru.akhramenko.computerstore.service.EquipmentSpecificationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/equipments")
public class EquipmentController {

    private EquipmentService equipmentService;
    private EquipmentSpecificationService equipmentSpecificationService;

    @GetMapping("")
    public List<EquipmentResponse> getAllEquipment() {
        return equipmentService.findAll();
    }

    @GetMapping("/{id}")
    public EquipmentResponse getEquipmentById(@PathVariable UUID id) {
        return equipmentService.findById(id);
    }

    @PostMapping("")
    public EquipmentResponse addNewEquipment(@RequestBody EquipmentRequest equipmentRequest) {
        return equipmentService.create(equipmentRequest);
    }

    @PatchMapping("/{id}")
    public EquipmentResponse updateEquipment(@PathVariable UUID id, @RequestBody EquipmentRequest equipmentRequest) {
        return equipmentService.update(id, equipmentRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipmentById(@PathVariable UUID id) {
        equipmentService.delete(id);
    }

    @PostMapping("/{id}/specifications")
    public EquipmentSpecificationResponse addNewEquipSpec(@RequestBody EquipmentSpecificationRequest equipmentSpecificationRequest) {
        return equipmentSpecificationService.create(equipmentSpecificationRequest);
    }

    @PutMapping("/{id}/specifications")
    public EquipmentSpecificationResponse updateEquipSpec(@PathVariable UUID id, @RequestBody EquipmentSpecificationRequest equipmentSpecificationRequest) {
        return equipmentSpecificationService.update(id, equipmentSpecificationRequest);
    }

    @DeleteMapping("/{id}/specifications")
    public void deleteEquipSpecById(UUID id) {
        equipmentSpecificationService.delete(id);
    }
}
