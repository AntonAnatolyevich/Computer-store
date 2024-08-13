package ru.akhramenko.computerstore.entity;

import jakarta.persistence.*;
import java.util.Set;
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

    @Column(name = "type_name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "equipmentTypeOfEquip",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Equipment> equipmentList;

    @OneToMany(mappedBy = "equipmentTypeOfSpec", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Specification> specificationList;
}
