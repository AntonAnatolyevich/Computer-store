package ru.akhramenko.computerstore.dto.equipmentspecification;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.akhramenko.computerstore.entity.Equipment;
import ru.akhramenko.computerstore.entity.Specification;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentSpecificationResponse {

    private UUID id;

    private Specification specification;

    private Equipment equipment;

    private String value;
}
