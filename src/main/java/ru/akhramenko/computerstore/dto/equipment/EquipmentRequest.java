package ru.akhramenko.computerstore.dto.equipment;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.akhramenko.computerstore.dto.equipmentspecification.EquipmentSpecificationRequest;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentRequest {

    @NotNull(message = "The equipment must be recognized before adding")
    private String equipmentType;

    @Size(min = 1, max = 20, message = "Name of developer should be between 1 and 20")
    private String devName;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price should be greater than 0")
    private BigDecimal price;

    private Set<EquipmentSpecificationRequest> equipmentSpecificationsList;
}
