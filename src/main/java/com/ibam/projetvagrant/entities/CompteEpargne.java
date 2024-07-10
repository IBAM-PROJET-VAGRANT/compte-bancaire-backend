package com.ibam.projetvagrant.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author S. Lamoussa OUATTARA
 * @date 10/07/2024
 */
@Entity
@DiscriminatorValue("CE")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompteEpargne extends  CompteBanque {

    @Column(name = "taux_interet")
    private Double tauxInteret;
}
