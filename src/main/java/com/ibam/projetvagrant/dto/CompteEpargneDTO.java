package com.ibam.projetvagrant.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author S. Lamoussa OUATTARA
 * @date 10/07/2024
 */
@Data
public class CompteEpargneDTO extends CompteBanqueDTO{
    private Long idCompteBanque;
    private String numero;
    private Date dateCreation;
    private String statut;
    private Double solde;
    private Double tauxInteret;
    private ClientDTO clientDTO;
}
