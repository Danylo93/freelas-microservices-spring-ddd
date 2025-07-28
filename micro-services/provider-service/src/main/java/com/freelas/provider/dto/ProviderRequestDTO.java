package com.freelas.provider.dto;

import lombok.Data;

@Data
public class ProviderRequestDTO {
    private String name;
    private String serviceType;
    private Double latitude;
    private Double longitude;
}
