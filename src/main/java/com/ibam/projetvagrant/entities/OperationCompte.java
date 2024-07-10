package com.ibam.projetvagrant.entities;

import com.ibam.projetvagrant.enums.ETypeOperation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author S. Lamoussa OUATTARA
 * @date 09/07/2024
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "operation_comptes")
public class OperationCompte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operation_compte")
    private Long idOperationCompte;

    @Column(name = "date_operation")
    private Date dateOperation;

    private Double montant;

    @Enumerated(EnumType.STRING)
    private ETypeOperation type;

    @ManyToOne
    @JoinColumn(name = "compte_banque_id", nullable = false)
    private CompteBanque compte;

    private String description;
}
