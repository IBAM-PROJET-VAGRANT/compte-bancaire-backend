package com.ibam.projetvagrant.entities;

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
@DiscriminatorValue("CC")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompteCourant extends  CompteBanque {

    private Double decouvert;
}
