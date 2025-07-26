package com.freelas.billing.controller;

import com.freelas.billing.dto.BillingRequestDTO;
import com.freelas.billing.dto.BillingResponseDTO;
import com.freelas.billing.service.BillingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/billing")
@RequiredArgsConstructor
public class BillingController {

    private final BillingService billingService;

    @PostMapping("/estimate")
    public ResponseEntity<BillingResponseDTO> estimate(@RequestBody BillingRequestDTO dto) {
        return ResponseEntity.ok(billingService.calculate(dto));
    }
}
