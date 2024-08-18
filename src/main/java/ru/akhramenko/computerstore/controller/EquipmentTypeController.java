package ru.akhramenko.computerstore.controller;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.akhramenko.computerstore.dto.equipment.EquipmentResponse;
import ru.akhramenko.computerstore.dto.type.EquipmentTypeRequest;
import ru.akhramenko.computerstore.dto.type.EquipmentTypeResponse;
import ru.akhramenko.computerstore.service.EquipmentService;
import ru.akhramenko.computerstore.service.EquipmentTypeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/equipment-types")
public class EquipmentTypeController {

    private final EquipmentTypeService equipmentTypeService;
    private final EquipmentService equipmentService;

    @GetMapping("")
    public List<EquipmentTypeResponse> getAllEquipmentTypes() {
        return equipmentTypeService.findAll();
    }

    @GetMapping("/{id}")
    public EquipmentTypeResponse getEquipmentTypeById(@PathVariable UUID id) {
        return equipmentTypeService.findById(id);
    }

    @GetMapping("/{id}/equipments")
    public List<EquipmentResponse> getEquipmentTypeByIdWithEquipments(@PathVariable UUID id) {
        return equipmentService.findEquipmentsByType(id);
    }

    @PostMapping("")
    public EquipmentTypeResponse addNewEquipmentType(@RequestBody EquipmentTypeRequest equipmentTypeRequest) {
        return equipmentTypeService.create(equipmentTypeRequest);
    }

    @PatchMapping("/{id}")
    public EquipmentTypeResponse updateEquipmentType(@PathVariable UUID id, @RequestBody EquipmentTypeRequest equipmentTypeRequest) {
        return equipmentTypeService.update(id, equipmentTypeRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipmentTypeById(@PathVariable UUID id) {
        equipmentTypeService.delete(id);
    }
}
