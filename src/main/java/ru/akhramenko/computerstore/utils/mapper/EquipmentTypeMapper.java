package ru.akhramenko.computerstore.utils.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.akhramenko.computerstore.dto.type.EquipmentTypeRequest;
import ru.akhramenko.computerstore.dto.type.EquipmentTypeResponse;
import ru.akhramenko.computerstore.entity.EquipmentType;

@Component
@Mapper
public interface EquipmentTypeMapper {
    EquipmentType toEquipmentType(EquipmentTypeRequest equipmentTypeRequest);
    EquipmentTypeResponse toEquipmentTypeResponse(EquipmentType equipmentType);
}
