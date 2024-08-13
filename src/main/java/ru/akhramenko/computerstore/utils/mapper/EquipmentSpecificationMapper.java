package ru.akhramenko.computerstore.utils.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.akhramenko.computerstore.dto.equipmentspecification.EquipmentSpecificationRequest;
import ru.akhramenko.computerstore.dto.equipmentspecification.EquipmentSpecificationResponse;
import ru.akhramenko.computerstore.entity.EquipmentSpecification;

@Component
@Mapper
public interface EquipmentSpecificationMapper {
    EquipmentSpecification toEquipmentSpecification(EquipmentSpecificationRequest equipmentSpecificationRequest);
    EquipmentSpecificationResponse toEquipmentSpecificationResponse(EquipmentSpecification equipmentSpecification);
}
