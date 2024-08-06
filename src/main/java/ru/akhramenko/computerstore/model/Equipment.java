package ru.akhramenko.computerstore.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", nullable = true)
    private EquipmentType equipmentTypeOfEquip;

    @Column(name = "developer_name")
    private String devName;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "added_at")
    private Date addedAt;

    @OneToMany(mappedBy = "equipment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EquipmentSpecification> equipmentSpecificationsList;
}
