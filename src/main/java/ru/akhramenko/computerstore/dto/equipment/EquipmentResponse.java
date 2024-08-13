package ru.akhramenko.computerstore.dto.equipment;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.akhramenko.computerstore.dto.equipmentspecification.EquipmentSpecificationResponse;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentResponse {

    private UUID id;

    private String  equipmentType;

    private String devName;

    private BigDecimal price;

    private Set<EquipmentSpecificationResponse> equipmentSpecificationsList;

}
