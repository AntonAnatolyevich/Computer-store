package ru.akhramenko.computerstore.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.akhramenko.computerstore.dto.equipmentspecification.EquipmentSpecificationRequest;
import ru.akhramenko.computerstore.dto.equipmentspecification.EquipmentSpecificationResponse;
import ru.akhramenko.computerstore.entity.EquipmentSpecification;
import ru.akhramenko.computerstore.repo.EquipmentSpecificationRepo;
import ru.akhramenko.computerstore.utils.exception.ResourceNotFoundException;
import ru.akhramenko.computerstore.utils.mapper.EquipmentSpecificationMapper;

@Service
@RequiredArgsConstructor
public class EquipmentSpecificationService {

    private final EquipmentSpecificationRepo equipmentSpecificationRepo;
    private final EquipmentSpecificationMapper equipmentSpecificationMapper;

    public List<EquipmentSpecificationResponse> findAll() {
        return equipmentSpecificationRepo.findAll().stream()
                .map(equipmentSpecificationMapper::toEquipmentSpecificationResponse)
                .collect(Collectors.toList());
    }

    public EquipmentSpecificationResponse findById(UUID id) {
        EquipmentSpecification equipmentSpecification = equipmentSpecificationRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return equipmentSpecificationMapper.toEquipmentSpecificationResponse(equipmentSpecification);
    }

    @Transactional
    public EquipmentSpecificationResponse create(EquipmentSpecificationRequest equipmentSpecificationRequest) {
        EquipmentSpecification equipmentSpecification = equipmentSpecificationMapper.toEquipmentSpecification(equipmentSpecificationRequest);
        EquipmentSpecification savedEquipmentSpecification = equipmentSpecificationRepo.save(equipmentSpecification);
        return equipmentSpecificationMapper.toEquipmentSpecificationResponse(savedEquipmentSpecification);
    }

    @Transactional
    public EquipmentSpecificationResponse update(UUID id, EquipmentSpecificationRequest equipmentSpecificationRequest) {
        EquipmentSpecification existingEquipmentSpecification = equipmentSpecificationRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        EquipmentSpecification updatedEquipmentSpecification = equipmentSpecificationMapper.toEquipmentSpecification(equipmentSpecificationRequest);
        updatedEquipmentSpecification.setId(existingEquipmentSpecification.getId());
        equipmentSpecificationRepo.save(updatedEquipmentSpecification);
        return equipmentSpecificationMapper.toEquipmentSpecificationResponse(updatedEquipmentSpecification);

    }

    @Transactional
    public void delete(UUID id) {
        equipmentSpecificationRepo.deleteById(id);
    }
}
