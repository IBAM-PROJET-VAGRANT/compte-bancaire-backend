package com.ibam.projetvagrant.dto;

import com.ibam.projetvagrant.entities.CompteBanque;
import com.ibam.projetvagrant.enums.ETypeOperation;
import jakarta.persistence.*;
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
    private ETypeOperation type;
    private String description;
}
