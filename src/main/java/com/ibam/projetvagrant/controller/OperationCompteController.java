package com.ibam.projetvagrant.controller;

import com.ibam.projetvagrant.dto.*;
import com.ibam.projetvagrant.service.OperationCompteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author S. Lamoussa OUATTARA
 * @date 10/07/2024
 */
@RestController
@RequestMapping("operations")
@CrossOrigin("*")
@RequiredArgsConstructor
public class OperationCompteController {

    private final OperationCompteService operationCompteService;

    @PostMapping("/retrait")
    public void retrait(@RequestBody RetraitDTO retraitDTO) {
        operationCompteService.retrait(retraitDTO.getNumeroCompte(), retraitDTO.getMontant(), retraitDTO.getDescription());
    }

    @PostMapping("/depot")
    public void depot(@RequestBody DepotDTO depotDTO) {
        operationCompteService.depot(depotDTO.getNumeroCompte(), depotDTO.getMontant(), depotDTO.getDescription());
    }

    @PostMapping("/virement")
    public void virement(@RequestBody VirementDTO virementDTO) {
        operationCompteService.virement(virementDTO.getNumeroCompteSource(), virementDTO.getNumeroCompteDestination(), virementDTO.getMontant());
    }

    @GetMapping("/{numero-compte}")
    public ResponseEntity<List<OperationCompteDTO>> getHistoriqueByCompte(@PathVariable("numero-compte") String numeroCompte) {
        return ResponseEntity.ok(operationCompteService.findHistoriqueByCompte(numeroCompte));
    }

    @GetMapping("/{numero-compte}/par-page")
    public ResponseEntity<HistoriqueCompteDTO> getPaginateHistorique(
            @PathVariable("numero-compte") String numeroCompte,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int taille) {
        return ResponseEntity.ok(operationCompteService.findPaginateHistoriqueByCompte(numeroCompte,page, taille));
    }
}
