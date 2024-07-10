package com.ibam.projetvagrant.controller;

import com.ibam.projetvagrant.dto.CompteBanqueDTO;
import com.ibam.projetvagrant.dto.CompteCourantDTO;
import com.ibam.projetvagrant.dto.CompteEpargneDTO;
import com.ibam.projetvagrant.service.CompteBanqueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author S. Lamoussa OUATTARA
 * @date 10/07/2024
 */
@RestController
@RequestMapping("comptes")
@CrossOrigin("*")
@RequiredArgsConstructor
@Slf4j
public class CompteBanqueController {

    private final CompteBanqueService compteBanqueService;

    @PostMapping("/compte-courant")
    public ResponseEntity<CompteCourantDTO> createCompteCourant(@RequestBody CompteCourantDTO compteBanqueDTO) {
        log.info("_____________CompteBanqueDTO= {}", compteBanqueDTO);
        return ResponseEntity.ok(compteBanqueService.createOrUpdateCompteCourant(compteBanqueDTO));
    }

    @PostMapping("/compte-epargne")
    public ResponseEntity<CompteEpargneDTO> createCompteEpargne(@RequestBody CompteEpargneDTO compteBanqueDTO) {
        return ResponseEntity.ok(compteBanqueService.createOrUpdateCompteEpargne(compteBanqueDTO));
    }

    @PutMapping("/compte-courant/{compte-id}")
    public ResponseEntity<CompteCourantDTO> updateCompteCourant(@PathVariable("compte-id") Long compteId, @RequestBody CompteCourantDTO compteBanqueDTO) {
        log.info("_____________Compte courant to update [" + compteId + "]");
        return ResponseEntity.ok(compteBanqueService.createOrUpdateCompteCourant(compteBanqueDTO));
    }

    @PutMapping("/compte-epargne/{compte-id}")
    public ResponseEntity<CompteEpargneDTO> updateCompteEpargne(@PathVariable("compte-id") Long compteId, @RequestBody CompteEpargneDTO compteBanqueDTO) {
        log.info("_____________Compte epargne to update [" + compteId + "]");
        return ResponseEntity.ok(compteBanqueService.createOrUpdateCompteEpargne(compteBanqueDTO));
    }

    @GetMapping
    public ResponseEntity<List<CompteBanqueDTO>> findAllComptes() {
        return ResponseEntity.ok(compteBanqueService.findAllCompteBanque());
    }

    @GetMapping("/{compte-id}")
    public ResponseEntity<CompteBanqueDTO> findCompte(@PathVariable("compte-id") Long compteId) {
        return ResponseEntity.ok(compteBanqueService.findCompteBanque(compteId));
    }
}
