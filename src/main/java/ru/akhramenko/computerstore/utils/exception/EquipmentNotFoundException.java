package ru.akhramenko.computerstore.utils.exception;

import java.util.UUID;

public class EquipmentNotFoundException extends RuntimeException {
    private static final String ID_PREFIX = "Equipment wasn't found by id: %s";

    public EquipmentNotFoundException(UUID id) {
        super(String.format(ID_PREFIX, id));
    }
}
