package com.ibam.projetvagrant.repository;

import com.ibam.projetvagrant.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author S. Lamoussa OUATTARA
 * @date 10/07/2024
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
}
