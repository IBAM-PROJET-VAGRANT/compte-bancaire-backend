package com.ibam.projetvagrant.enums;

import lombok.Getter;

import java.util.stream.Stream;

/**
 * @author S. Lamoussa OUATTARA
 * @date 09/07/2024
 */
@Getter
public enum ETypeOperation {

    DEBIT(1, "Débit"),
    CREDIT(2, "Cédit");
    private Integer value;
    private String label;

    ETypeOperation(Integer pValue, String pLabel) {
        value = pValue;
        label = pLabel;
    }

    public static ETypeOperation getByValue(Character value) {
        return Stream.of(ETypeOperation.values()).filter(val -> val.getValue().equals(value)).findAny().orElse(null);
    }

    public static ETypeOperation getByLabel(String label) {
        return Stream.of(ETypeOperation.values()).filter(val -> val.getLabel().equals(label)).findAny().orElse(null);
    }
}
