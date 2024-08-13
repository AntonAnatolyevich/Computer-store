package ru.akhramenko.computerstore.dto.type;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentTypeResponse {

    private UUID id;

    private String name;

}
