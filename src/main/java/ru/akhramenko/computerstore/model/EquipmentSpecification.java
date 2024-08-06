package ru.akhramenko.computerstore.model;

import jakarta.persistence.*;
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
@Table(name = "equipment_spec")
public class EquipmentSpecification {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spec_id", nullable = true)
    private Specification specification;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equip_id", nullable = true)
    private Equipment equipment;

    @Column(name = "value")
    private String value;
}
