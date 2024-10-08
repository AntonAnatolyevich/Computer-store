package ru.akhramenko.computerstore.dto.specification;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpecificationRequest {

    @NotBlank
    @Size(min = 2, max = 20, message = "Equipment type name should be between 2 and 20")
    private UUID equipmentTypeId;

    @NotBlank
    @Size(min = 2, max = 20, message = "Name should be between 2 and 20")
    private String name;

}
