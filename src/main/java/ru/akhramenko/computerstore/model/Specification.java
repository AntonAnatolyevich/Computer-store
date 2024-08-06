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
@Table(name = "specification")
public class Specification {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id", nullable = true)
    private EquipmentType equipmentTypeOfSpec;

    @Column(name = "specification_name")
    private String name;

    @OneToMany(mappedBy = "specification", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EquipmentSpecification> equipmentSpecificationsList;
}
