package com.ibam.projetvagrant.enums;

import lombok.Getter;

import java.util.stream.Stream;

/**
 * @author S. Lamoussa OUATTARA
 * @date 09/07/2024
 */
@Getter
public enum EStatusBanque {
    CREATED(1, "Créé"),
    ACTIVATED(2, "Activé"),
    SUSPENDED(3, "Suspendu");

    private Integer value;
    private String label;

    EStatusBanque(Integer pValue, String pLabel) {
        value = pValue;
        label = pLabel;
    }

    public static EStatusBanque getByValue(Character value) {
        return Stream.of(EStatusBanque.values()).filter(val -> val.getValue().equals(value)).findAny().orElse(null);
    }

    public static EStatusBanque getByLabel(String label) {
        return Stream.of(EStatusBanque.values()).filter(val -> val.getLabel().equals(label)).findAny().orElse(null);
    }
}
