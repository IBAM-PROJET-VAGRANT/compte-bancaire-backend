package com.ibam.projetvagrant.controller;

import com.ibam.projetvagrant.dto.DepotDTO;
import com.ibam.projetvagrant.dto.RetraitDTO;
import com.ibam.projetvagrant.dto.VirementDTO;
import com.ibam.projetvagrant.service.OperationCompteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
