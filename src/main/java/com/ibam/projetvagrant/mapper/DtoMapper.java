package com.ibam.projetvagrant.mapper;

import com.ibam.projetvagrant.dto.ClientDTO;
import com.ibam.projetvagrant.dto.CompteCourantDTO;
import com.ibam.projetvagrant.dto.CompteEpargneDTO;
import com.ibam.projetvagrant.dto.OperationCompteDTO;
import com.ibam.projetvagrant.entities.Client;
import com.ibam.projetvagrant.entities.CompteCourant;
import com.ibam.projetvagrant.entities.CompteEpargne;
import com.ibam.projetvagrant.entities.OperationCompte;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author S. Lamoussa OUATTARA
 * @date 10/07/2024
 */
@Service
public class DtoMapper {

    public ClientDTO toClientDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        return clientDTO;
    }

    public Client toClient(ClientDTO clientDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        return client;
    }

    public CompteEpargneDTO toCompteEpargneDTO(CompteEpargne compteEpargne) {
        CompteEpargneDTO compteEpargneDTO = new CompteEpargneDTO();
        BeanUtils.copyProperties(compteEpargne, compteEpargneDTO);
        compteEpargneDTO.setClientDTO(toClientDTO(compteEpargne.getClient()));
        compteEpargneDTO.setType("CompteEpargne".equals(compteEpargne.getClass().getSimpleName()) ? "CE" : null);
        compteEpargneDTO.setStatut(compteEpargne.getStatut().getLabel());
        return compteEpargneDTO;
    }

    public CompteEpargne toCompteEpargne(CompteEpargneDTO compteEpargneDTO) {
        CompteEpargne compteEpargne = new CompteEpargne();
        BeanUtils.copyProperties(compteEpargneDTO, compteEpargne);
        compteEpargne.setClient(toClient(compteEpargneDTO.getClientDTO()));
        return compteEpargne;
    }

    public CompteCourantDTO toCompteCourantDTO(CompteCourant compteCourant) {
        CompteCourantDTO compteCourantDTO = new CompteCourantDTO();
        BeanUtils.copyProperties(compteCourant, compteCourantDTO);
        compteCourantDTO.setClientDTO(toClientDTO(compteCourant.getClient()));
        compteCourantDTO.setType("CompteCourant".equals(compteCourant.getClass().getSimpleName()) ? "CC" : null);
        compteCourantDTO.setStatut(compteCourant.getStatut().getLabel());
        return compteCourantDTO;
    }

    public CompteCourant toCompteCourant(CompteCourantDTO compteCourantDTO) {
        CompteCourant compteCourant = new CompteCourant();
        BeanUtils.copyProperties(compteCourantDTO, compteCourant);
        compteCourant.setClient(toClient(compteCourantDTO.getClientDTO()));
        return compteCourant;
    }

    public OperationCompteDTO toOperationCompteDTO(OperationCompte operationCompte) {
        OperationCompteDTO operationCompteDTO = new OperationCompteDTO();
        BeanUtils.copyProperties(operationCompte, operationCompteDTO);
        operationCompteDTO.setType(operationCompte.getType().toString());
        return  operationCompteDTO;
    }
}
