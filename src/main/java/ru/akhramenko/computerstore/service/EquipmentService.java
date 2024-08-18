package ru.akhramenko.computerstore.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.akhramenko.computerstore.dto.equipment.EquipmentRequest;
import ru.akhramenko.computerstore.dto.equipment.EquipmentResponse;
import ru.akhramenko.computerstore.entity.Equipment;
import ru.akhramenko.computerstore.repo.EquipmentRepo;
import ru.akhramenko.computerstore.utils.exception.ResourceNotFoundException;
import ru.akhramenko.computerstore.utils.mapper.EquipmentMapper;

@Service
@RequiredArgsConstructor
public class EquipmentService {

    private final EquipmentRepo equipmentRepo;
    private final EquipmentMapper equipmentMapper;


    public List<EquipmentResponse> findAll() {
        return equipmentRepo.findAll().stream()
                .map(equipmentMapper::toEquipmentResponse)
                .collect(Collectors.toList());
    }

    public EquipmentResponse findById(UUID id) {
        Equipment equipment = equipmentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return equipmentMapper.toEquipmentResponse(equipment);
    }

    @Transactional
    public List<EquipmentResponse> findEquipmentsByType(UUID id) {
        return equipmentRepo.findEquipmentsByType(id).stream()
                .map(equipmentMapper::toEquipmentResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public EquipmentResponse create(EquipmentRequest equipmentRequest) {
        Equipment equipment = equipmentMapper.toEquipment(equipmentRequest);
        Equipment savedEquipment = equipmentRepo.save(equipment);
        return equipmentMapper.toEquipmentResponse(savedEquipment);
    }

    @Transactional
    public EquipmentResponse update(UUID id, EquipmentRequest equipmentRequest) {
       Equipment existingEquipment = equipmentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
       Equipment updatedEquipment = equipmentMapper.toEquipment(equipmentRequest);
       updatedEquipment.setId(existingEquipment.getId());
       equipmentRepo.save(updatedEquipment);
       return equipmentMapper.toEquipmentResponse(updatedEquipment);

    }

    @Transactional
    public void delete(UUID id) {
        equipmentRepo.deleteById(id);
    }
}
