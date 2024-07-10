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
        BeanUtils.copyProperties(clientDTO, client);
        return clientDTO;
    }

    public Client toClient(ClientDTO clientDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(client, clientDTO);
        return client;
    }

    public CompteEpargneDTO toCompteEpargneDTO(CompteEpargne compteEpargne) {
        CompteEpargneDTO compteEpargneDTO = new CompteEpargneDTO();
        BeanUtils.copyProperties(compteEpargneDTO, compteEpargne);
        compteEpargneDTO.setClientDTO(toClientDTO(compteEpargne.getClient()));
        compteEpargneDTO.setType(compteEpargne.getClass().getSimpleName());
        return compteEpargneDTO;
    }

    public CompteEpargne toCompteEpargne(CompteEpargneDTO compteEpargneDTO) {
        CompteEpargne compteEpargne = new CompteEpargne();
        BeanUtils.copyProperties(compteEpargne, compteEpargneDTO);
        compteEpargne.setClient(toClient(compteEpargneDTO.getClientDTO()));
        return compteEpargne;
    }

    public CompteCourantDTO toCompteCourantDTO(CompteCourant compteCourant) {
        CompteCourantDTO compteCourantDTO = new CompteCourantDTO();
        BeanUtils.copyProperties(compteCourantDTO, compteCourant);
        compteCourantDTO.setClientDTO(toClientDTO(compteCourant.getClient()));
        compteCourantDTO.setType(compteCourant.getClass().getSimpleName());
        return compteCourantDTO;
    }

    public CompteCourant toCompteCourant(CompteCourantDTO compteCourantDTO) {
        CompteCourant compteCourant = new CompteCourant();
        BeanUtils.copyProperties(compteCourant, compteCourantDTO);
        compteCourant.setClient(toClient(compteCourantDTO.getClientDTO()));
        return compteCourant;
    }

    public OperationCompteDTO toOperationCompteDTO(OperationCompte operationCompte) {
        OperationCompteDTO operationCompteDTO = new OperationCompteDTO();
        BeanUtils.copyProperties(operationCompteDTO, operationCompte);
        return  operationCompteDTO;
    }
}
