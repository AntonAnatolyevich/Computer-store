package ru.akhramenko.computerstore.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "equipment_type")
public class EquipmentType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "type_name")
    private String name;

    @OneToMany(mappedBy = "equipmentTypeOfEquip",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Equipment> equipmentList;

    @OneToMany(mappedBy = "equipmentTypeOfSpec", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Specification> specificationList;
}
