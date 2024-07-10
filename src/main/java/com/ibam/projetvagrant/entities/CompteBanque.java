package com.ibam.projetvagrant.entities;

import com.ibam.projetvagrant.enums.EStatusBanque;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author S. Lamoussa OUATTARA
 * @date 09/07/2024
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", length = 2)
@Entity
@Table(name = "compte_banque")
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class CompteBanque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compte_banque")
    private Long idCompteBanque;

    @Column(name = "numero", length = 12, unique = true, nullable = false)
    private String numero;

    @Column(name = "date_creation", nullable = false)
    private Date dateCreation;

    @Enumerated(EnumType.STRING)
    private EStatusBanque statut;

    private Double solde;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "compte")
    private List<OperationCompte> operations;

}
