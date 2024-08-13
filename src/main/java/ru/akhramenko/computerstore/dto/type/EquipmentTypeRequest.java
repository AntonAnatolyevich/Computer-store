package ru.akhramenko.computerstore.dto.type;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentTypeRequest {

    @NotEmpty
    @Size(min = 2, max = 20, message = "Name should be between 2 and 20")
    private String name;

}
