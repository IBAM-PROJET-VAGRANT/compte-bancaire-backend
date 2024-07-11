package com.ibam.projetvagrant.service;

import com.ibam.projetvagrant.dto.HistoriqueCompteDTO;
import com.ibam.projetvagrant.dto.OperationCompteDTO;
import com.ibam.projetvagrant.entities.CompteBanque;
import com.ibam.projetvagrant.entities.OperationCompte;
import com.ibam.projetvagrant.enums.ETypeOperation;
import com.ibam.projetvagrant.mapper.DtoMapper;
import com.ibam.projetvagrant.repository.CompteBanqueRepository;
import com.ibam.projetvagrant.repository.OperationCompteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author S. Lamoussa OUATTARA
 * @date 10/07/2024
 */
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class OperationCompteService {

    private final OperationCompteRepository operationCompteRepository;
    private final CompteBanqueRepository compteBanqueRepository;

    private final DtoMapper mapper;

    public void depot(String numeroCompte, Double montant, String description) {
        log.info("............Depot initié avec succès......................");
        CompteBanque compteBanque = getCompteBanque(numeroCompte);
        OperationCompte operationCompte = new OperationCompte();
        operationCompte.setDateOperation(new Date());
        operationCompte.setCompte(compteBanque);
        operationCompte.setType(ETypeOperation.CREDIT);
        operationCompte.setMontant(montant);
        operationCompte.setDescription(description);
        operationCompteRepository.save(operationCompte);
        compteBanque.setSolde(compteBanque.getSolde() + montant);
        compteBanqueRepository.save(compteBanque);
        log.info("_____________Dépot effectué avec succès____________");
    }

    public void retrait(String numeroCompte, Double montant, String description) {
        log.info("............Retrait initié avec succès...............");
        CompteBanque compteBanque = getCompteBanque(numeroCompte);
        if (compteBanque.getSolde() < montant) {
            throw new RuntimeException("Désolé votre solde est insuffisant pour effectuer cette opération");
        }
        OperationCompte operationCompte = new OperationCompte();
        operationCompte.setDateOperation(new Date());
        operationCompte.setCompte(compteBanque);
        operationCompte.setType(ETypeOperation.DEBIT);
        operationCompte.setMontant(montant);
        operationCompte.setDescription(description);
        operationCompteRepository.save(operationCompte);
        compteBanque.setSolde(compteBanque.getSolde() - montant);
        compteBanqueRepository.save(compteBanque);
        log.info("_____________Retrait effectué avec succès____________");
    }

    public void virement(String numeroCompteSource, String numeroCompteDestination, Double montant) {
        retrait(numeroCompteSource, montant, "Virement vers le compte : " + numeroCompteDestination);
        depot(numeroCompteDestination, montant, "Virement reçu du compte: " + numeroCompteSource);
    }
    private CompteBanque getCompteBanque(String numeroCompte) {
        return compteBanqueRepository.findByNumero(numeroCompte).orElseThrow(() -> new RuntimeException("Compte avec numéro [" + numeroCompte + "] introuvable"));
    }

    public List<OperationCompteDTO> findHistoriqueByCompte(String numeroCompte) {
        CompteBanque compteBanque = getCompteBanque(numeroCompte);
        return operationCompteRepository.findByCompte(compteBanque).stream().map(mapper::toOperationCompteDTO).collect(Collectors.toList());
    }

    public HistoriqueCompteDTO findPaginateHistoriqueByCompte(String numeroCompte, int page, int taille) {
        HistoriqueCompteDTO historiqueCompteDTO = new HistoriqueCompteDTO();
        CompteBanque compteBanque = getCompteBanque(numeroCompte);
        Page<OperationCompte> operationComptes =  operationCompteRepository.findByCompteOrderByDateOperationDesc(compteBanque, PageRequest.of(page, taille));
        List<OperationCompteDTO> operationCompteDTOS = operationComptes.getContent().stream().map(mapper::toOperationCompteDTO).collect(Collectors.toList());
        historiqueCompteDTO.setOperationCompteDTO(operationCompteDTOS);
        historiqueCompteDTO.setNumeroCompte(compteBanque.getNumero());
        historiqueCompteDTO.setSolde(compteBanque.getSolde());
        historiqueCompteDTO.setPageCourrant(page);
        historiqueCompteDTO.setTaillePage(taille);
        historiqueCompteDTO.setTotalPages(operationComptes.getTotalPages());
        return historiqueCompteDTO;
    }
}
