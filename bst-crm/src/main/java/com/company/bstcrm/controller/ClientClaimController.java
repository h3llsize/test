package com.company.bstcrm.controller;

import com.company.bstcrm.dto.ClientClaimAvitoDTO;
import com.company.bstcrm.service.ClientClaimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/avito")
public class ClientClaimController {

    private final ClientClaimService clientClaimService;

    public ClientClaimController(ClientClaimService clientClaimService) {
        this.clientClaimService = clientClaimService;
    }

    @PostMapping("/create-claim")
    public ResponseEntity<String> createClaim(@RequestBody ClientClaimAvitoDTO avitoDTO) {
        clientClaimService.createClaim(avitoDTO);

        return ResponseEntity.ok("Success");
    }
}
