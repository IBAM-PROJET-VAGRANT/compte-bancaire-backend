package com.ibam.projetvagrant.dto;

import lombok.Data;

/**
 * @author S. Lamoussa OUATTARA
 * @date 10/07/2024
 */
@Data
public class CreditDTO {
    private String numeroCompte;
    private Double montant;
    private String description;
}
