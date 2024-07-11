package com.ibam.projetvagrant.repository;

import com.ibam.projetvagrant.entities.CompteBanque;
import com.ibam.projetvagrant.entities.OperationCompte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author S. Lamoussa OUATTARA
 * @date 10/07/2024
 */
public interface OperationCompteRepository extends JpaRepository<OperationCompte, Long> {
    List<OperationCompte> findByCompte(CompteBanque compteBanque);
    Page<OperationCompte> findByCompteOrderByDateOperationDesc(CompteBanque compteBanque, Pageable pageable);
}
