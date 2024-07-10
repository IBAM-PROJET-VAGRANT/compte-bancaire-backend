package com.ibam.projetvagrant.service;

import com.ibam.projetvagrant.dto.CompteBanqueDTO;
import com.ibam.projetvagrant.dto.CompteCourantDTO;
import com.ibam.projetvagrant.dto.CompteEpargneDTO;
import com.ibam.projetvagrant.entities.CompteBanque;
import com.ibam.projetvagrant.entities.CompteCourant;
import com.ibam.projetvagrant.entities.CompteEpargne;
import com.ibam.projetvagrant.enums.EStatusBanque;
import com.ibam.projetvagrant.mapper.DtoMapper;
import com.ibam.projetvagrant.repository.CompteBanqueRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author S. Lamoussa OUATTARA
 * @date 10/07/2024
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class CompteBanqueService {

    private final CompteBanqueRepository compteBanqueRepository;

    private final DtoMapper mapper;

    public CompteBanqueDTO createOrUpdateCompte(CompteBanqueDTO compteBanqueDTO) {
        CompteBanqueDTO result = null;
        if(compteBanqueDTO instanceof CompteEpargneDTO compteEpargneDTO ) {
            result = createOrUpdateCompteEpargne(compteEpargneDTO);
        } else if(compteBanqueDTO instanceof CompteCourantDTO compteCourantDTO) {
            result = createOrUpdateCompteCourant(compteCourantDTO);
        }
        return result;
    }

    public CompteEpargneDTO createOrUpdateCompteEpargne(CompteEpargneDTO compteEpargneDTO) {
        log.info("______________________________COMPTE_EPARGNE : {}", compteEpargneDTO);
        CompteEpargne compteEpargne = mapper.toCompteEpargne(compteEpargneDTO);
        if(null == compteEpargne.getIdCompteBanque()) {
            compteEpargne.setDateCreation(new Date());
            compteEpargne.setStatut(EStatusBanque.CREATED);
        } else {
            compteEpargne.setStatut(EStatusBanque.getByLabel(compteEpargneDTO.getStatut()));
        }
        return mapper.toCompteEpargneDTO(compteBanqueRepository.save(compteEpargne));
    }

    public CompteCourantDTO createOrUpdateCompteCourant(CompteCourantDTO compteCourantDTO) {
        log.info("______________________________COMPTE_COURANT : {}", compteCourantDTO);
        CompteCourant compteCourant = mapper.toCompteCourant(compteCourantDTO);
        if(null == compteCourant.getIdCompteBanque()) {
            compteCourant.setDateCreation(new Date());
            compteCourant.setStatut(EStatusBanque.CREATED);
        } else {
            compteCourant.setStatut(EStatusBanque.getByLabel(compteCourantDTO.getStatut()));
        }
        return mapper.toCompteCourantDTO(compteBanqueRepository.save(compteCourant));
    }

    public List<CompteBanqueDTO> findAllCompteBanque() {
        return compteBanqueRepository.findAll().stream().map(compteBanque -> {
            if(compteBanque instanceof CompteEpargne compteEpargne) {
                return mapper.toCompteEpargneDTO(compteEpargne);
            } else{
                return mapper.toCompteCourantDTO((CompteCourant) compteBanque);
            }
        }).collect(Collectors.toList());
    }

    public CompteBanqueDTO findCompteBanque(Long compteBanqueId) {
        CompteBanque compteBanque = compteBanqueRepository.findById(compteBanqueId).orElseThrow(() -> new RuntimeException("Compte avec identifiant [" + compteBanqueId + "] introuvalbe."));
        if (compteBanque instanceof CompteEpargne compteEpargne) {
            return mapper.toCompteEpargneDTO(compteEpargne);
        } else {
            return mapper.toCompteCourantDTO((CompteCourant) compteBanque);
        }
    }

}
