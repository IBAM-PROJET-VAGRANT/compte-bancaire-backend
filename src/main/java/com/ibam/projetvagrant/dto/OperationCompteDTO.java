package com.ibam.projetvagrant.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author S. Lamoussa OUATTARA
 * @date 10/07/2024
 */

@Data
public class OperationCompteDTO {

    private Long idOperationCompte;
    private Date dateOperation;
    private Double montant;
    private String type;
    private String description;
}
