package com.ibam.projetvagrant.dto;

import lombok.Data;

/**
 * @author S. Lamoussa OUATTARA
 * @date 10/07/2024
 */

@Data
public class VirementDTO {
    private String numeroCompteSource;
    private String numeroCompteDestination;
    private Double montant;
    private String description;
}
