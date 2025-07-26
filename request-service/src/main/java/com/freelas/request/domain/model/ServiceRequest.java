package com.freelas.request.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientName;
    private String serviceType;
    private Double latitude;
    private Double longitude;
    private String status; // PENDING, MATCHED, ACCEPTED
}
