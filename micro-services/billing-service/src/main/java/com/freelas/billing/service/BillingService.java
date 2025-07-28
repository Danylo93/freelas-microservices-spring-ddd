package com.freelas.billing.service;

import com.freelas.billing.dto.BillingRequestDTO;
import com.freelas.billing.dto.BillingResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class BillingService {

    public BillingResponseDTO calculate(BillingRequestDTO dto) {
        double base = 30.0; // valor base
        double multiplier = switch (dto.getServiceType().toLowerCase()) {
            case "pedreiro" -> 1.5;
            case "eletricista" -> 1.7;
            case "encanador" -> 1.6;
            default -> 1.2;
        };

        double value = base + (dto.getDistanceKm() * 2.5 * multiplier);

        return BillingResponseDTO.builder()
                .serviceType(dto.getServiceType())
                .distanceKm(dto.getDistanceKm())
                .estimatedValue(value)
                .build();
    }
}
