package ru.akhramenko.computerstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.akhramenko.computerstore.repo.EquipmentSpecificationRepo;

@Service
@Transactional
public class EquipmentSpecificationService {

    private EquipmentSpecificationRepo equipmentSpecificationRepo;

    @Autowired
    public EquipmentSpecificationService(EquipmentSpecificationRepo equipmentSpecificationRepo) {
        this.equipmentSpecificationRepo = equipmentSpecificationRepo;
    }

}
