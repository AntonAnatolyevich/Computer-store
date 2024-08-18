package ru.akhramenko.computerstore.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.akhramenko.computerstore.dto.type.EquipmentTypeRequest;
import ru.akhramenko.computerstore.dto.type.EquipmentTypeResponse;
import ru.akhramenko.computerstore.entity.EquipmentType;
import ru.akhramenko.computerstore.repo.EquipmentTypeRepo;
import ru.akhramenko.computerstore.utils.exception.ResourceNotFoundException;
import ru.akhramenko.computerstore.utils.mapper.EquipmentTypeMapper;

@Service
@RequiredArgsConstructor
public class EquipmentTypeService {

    private final EquipmentTypeRepo equipmentTypeRepo;
    private final EquipmentTypeMapper equipmentTypeMapper;


    public List<EquipmentTypeResponse> findAll() {
        return equipmentTypeRepo.findAll().stream()
                .map(equipmentTypeMapper::toEquipmentTypeResponse)
                .collect(Collectors.toList());
    }

    public EquipmentTypeResponse findById(UUID id) {
        EquipmentType equipmentType = equipmentTypeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return equipmentTypeMapper.toEquipmentTypeResponse(equipmentType);
    }

    @Transactional
    public EquipmentTypeResponse create(EquipmentTypeRequest equipmentTypeRequest) {
        EquipmentType equipmentType = equipmentTypeMapper.toEquipmentType(equipmentTypeRequest);
        EquipmentType savedEquipmentType = equipmentTypeRepo.save(equipmentType);
        return equipmentTypeMapper.toEquipmentTypeResponse(savedEquipmentType);
    }

    @Transactional
    public EquipmentTypeResponse update(UUID id, EquipmentTypeRequest equipmentTypeRequest) {
        EquipmentType existingEquipmentType = equipmentTypeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        EquipmentType updatedEquipmentType = equipmentTypeMapper.toEquipmentType(equipmentTypeRequest);
        updatedEquipmentType.setId(existingEquipmentType.getId());
        equipmentTypeRepo.save(updatedEquipmentType);
        return equipmentTypeMapper.toEquipmentTypeResponse(updatedEquipmentType);

    }

    @Transactional
    public void delete(UUID id) {
        equipmentTypeRepo.deleteById(id);
    }
}
