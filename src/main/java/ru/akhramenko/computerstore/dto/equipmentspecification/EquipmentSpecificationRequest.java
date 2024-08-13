package ru.akhramenko.computerstore.dto.equipmentspecification;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentSpecificationRequest {

    @NotEmpty
    @Size(min = 2, max = 20, message = "Specification should be between 2 and 20")
    private UUID specificationId;

    @NotBlank
    @Size(min = 2, max = 20, message = "Value should be between 2 and 20")
    //TODO подумать над @Pattern, нужен ли и как должен выглядеть
    private String value;

}
