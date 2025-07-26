package com.freelas.client.controller;

import com.freelas.client.domain.model.Client;
import com.freelas.client.domain.service.ClientService;
import com.freelas.client.dto.ClientRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody ClientRequestDTO dto) {
        return ResponseEntity.ok(clientService.register(dto));
    }
}
