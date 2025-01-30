package com.example.pos_system.entity;

import java.util.Arrays;
import java.util.Optional;

public enum Unit {
    KG, LITRE, PCS, BOX;

    public static Optional<Unit> fromString(String unit) {
        return Arrays.stream(Unit.values())
                .filter(e -> e.name().equalsIgnoreCase(unit))
                .findFirst();
    }
}
