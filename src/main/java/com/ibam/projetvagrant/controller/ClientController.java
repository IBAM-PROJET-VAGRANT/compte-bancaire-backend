package com.ibam.projetvagrant.controller;

import com.ibam.projetvagrant.dto.ClientDTO;
import com.ibam.projetvagrant.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author S. Lamoussa OUATTARA
 * @date 10/07/2024
 */
@RestController
@RequestMapping("clients")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.createOrUpdateClient(clientDTO));
    }

    @PutMapping("/{client-id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable("client-id") Long clientId, @RequestBody ClientDTO clientDTO){
        return ResponseEntity.ok(clientService.createOrUpdateClient(clientDTO));
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok(clientService.findAllClients());
    }

    @GetMapping("/{client-id}")
    public ResponseEntity<ClientDTO> findClient(@PathVariable("client-id") Long clientId) {
        return ResponseEntity.ok(clientService.findClient(clientId));
    }

    @DeleteMapping("/{client-id}")
    public ResponseEntity<String> deleteClient(@PathVariable("client-id") Long clientId) {
        return ResponseEntity.ok(clientService.deleteClient(clientId));
    }
}
