package com.ibam.projetvagrant.dto;

import jakarta.persistence.Column;
import lombok.Data;

/**
 * @author S. Lamoussa OUATTARA
 * @date 10/07/2024
 */
@Data
public class ClientDTO {
    private Long idClient;
    private String email;
    private String nom;
    private String prenom;
    private String telephone;
}
