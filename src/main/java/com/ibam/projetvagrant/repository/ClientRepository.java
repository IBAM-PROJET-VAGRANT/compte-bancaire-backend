package com.ibam.projetvagrant.repository;

import com.ibam.projetvagrant.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author S. Lamoussa OUATTARA
 * @date 10/07/2024
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("select c from Client c where c.nom like :term or c.prenom like :term or c.email like :term or c.telephone like :term")
    List<Client> searchClient(@Param("term") String searchTerm);
}
