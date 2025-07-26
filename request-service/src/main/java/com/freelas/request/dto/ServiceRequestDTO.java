package com.freelas.request.dto;

import lombok.Data;

@Data
public class ServiceRequestDTO {
    private String clientName;
    private String serviceType;
    private Double latitude;
    private Double longitude;
}
