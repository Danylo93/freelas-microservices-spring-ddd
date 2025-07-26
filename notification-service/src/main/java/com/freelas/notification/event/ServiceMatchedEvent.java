package com.freelas.notification.event;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceMatchedEvent {
    private Long requestId;
    private Long providerId;
    private String serviceType;
    private Double distanceKm;
}
