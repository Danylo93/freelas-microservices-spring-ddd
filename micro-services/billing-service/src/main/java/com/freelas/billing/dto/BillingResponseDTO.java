package com.freelas.billing.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillingResponseDTO {
    private String serviceType;
    private Double distanceKm;
    private Double estimatedValue;
}
