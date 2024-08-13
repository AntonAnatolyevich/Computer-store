package ru.akhramenko.computerstore.repo;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.akhramenko.computerstore.entity.EquipmentType;

@Repository
public interface EquipmentTypeRepo extends JpaRepository<EquipmentType, UUID> {
}
