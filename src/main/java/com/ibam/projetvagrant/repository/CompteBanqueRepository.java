package com.ibam.projetvagrant.repository;

import com.ibam.projetvagrant.entities.CompteBanque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author S. Lamoussa OUATTARA
 * @date 10/07/2024
 */
public interface CompteBanqueRepository extends JpaRepository<CompteBanque, Long> {
    Optional<CompteBanque> findByNumero(String numero);
}
