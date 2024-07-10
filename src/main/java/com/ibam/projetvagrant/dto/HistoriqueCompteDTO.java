package com.ibam.projetvagrant.dto;

import lombok.Data;

import java.util.List;

/**
 * @author S. Lamoussa OUATTARA
 * @date 10/07/2024
 */
@Data
public class HistoriqueCompteDTO {

    private String numeroCompte;
    private Double Solde;
    private int pageCourrant;
    private int taillePage;
    private int totalPages;
    List<OperationCompteDTO> operationCompteDTO;
}
