package com.ibam.projetvagrant.repository;

import com.ibam.projetvagrant.entities.CompteEpargne;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author S. Lamoussa OUATTARA
 * @date 10/07/2024
 */
public interface CompteBanqueRepository extends JpaRepository<CompteEpargne, Long> {
}
