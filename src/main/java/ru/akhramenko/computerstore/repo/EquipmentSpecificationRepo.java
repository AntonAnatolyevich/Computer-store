package ru.akhramenko.computerstore.repo;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.akhramenko.computerstore.entity.EquipmentSpecification;

@Repository
public interface EquipmentSpecificationRepo extends JpaRepository<EquipmentSpecification, UUID> {
}
