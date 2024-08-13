package ru.akhramenko.computerstore.utils.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.akhramenko.computerstore.dto.equipment.EquipmentRequest;
import ru.akhramenko.computerstore.dto.equipment.EquipmentResponse;
import ru.akhramenko.computerstore.entity.Equipment;

@Component
@Mapper(uses = EquipmentSpecificationMapper.class)
public interface EquipmentMapper {
    Equipment toEquipment(EquipmentRequest equipmentRequest);
    EquipmentResponse toEquipmentResponse(Equipment equipment);
}
