package com.ibam.projetvagrant.service;

import com.ibam.projetvagrant.dto.ClientDTO;
import com.ibam.projetvagrant.entities.Client;
import com.ibam.projetvagrant.mapper.DtoMapper;
import com.ibam.projetvagrant.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author S. Lamoussa OUATTARA
 * @date 10/07/2024
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {

    private final ClientRepository clientRepository;

    private final DtoMapper mapper;

    public ClientDTO createOrUpdateClient(ClientDTO clientDTO) {
        log.info("______________CREATE OR UPDATE CLIENT REQUEST::{}", clientDTO);
        Client client = mapper.toClient(clientDTO);
        return mapper.toClientDTO(clientRepository.save(client));
    }

    public List<ClientDTO> findAllClients() {
        return clientRepository.findAll().stream().map(mapper::toClientDTO).collect(Collectors.toList());
    }

    public ClientDTO findClient(Long clientId) {
        Client client =  clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client avec identifiant: "+ clientId + " est introuvable."));
        return mapper.toClientDTO(client);
    }

    public String deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
        return "Client supprimé.";
    }

    public List<ClientDTO> searchClient(String searchTerm) {
        return clientRepository.searchClient(searchTerm).stream()
                .map(mapper::toClientDTO).collect(Collectors.toList());
    }
}
