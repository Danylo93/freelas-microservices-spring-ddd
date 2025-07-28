package com.freelas.billing.dto;

import lombok.Data;

@Data
public class BillingRequestDTO {
    private String serviceType;
    private Double distanceKm;
}
