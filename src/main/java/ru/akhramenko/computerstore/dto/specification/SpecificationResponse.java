package ru.akhramenko.computerstore.dto.specification;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpecificationResponse {

    private UUID id;

    private String equipmentType;

    private String name;

}
