package com.freelas.provider.controller;

import com.freelas.provider.domain.model.Provider;
import com.freelas.provider.domain.service.ProviderService;
import com.freelas.provider.dto.ProviderRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/providers")
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderService providerService;

    @PostMapping
    public ResponseEntity<Provider> create(@RequestBody ProviderRequestDTO dto) {
        Provider created = providerService.createProvider(dto);
        return ResponseEntity.ok(created);
    }
}
