package com.ibam.projetvagrant.dto;

import com.ibam.projetvagrant.enums.EStatusBanque;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.Date;

/**
 * @author S. Lamoussa OUATTARA
 * @date 10/07/2024
 */
@Data
public class CompteCourantDTO extends CompteBanqueDTO{

    private Long idCompteBanque;
    private String numero;
    private Date dateCreation;
    private String statut;
    private Double solde;
    private Double decouvert;
    private ClientDTO clientDTO;
}
