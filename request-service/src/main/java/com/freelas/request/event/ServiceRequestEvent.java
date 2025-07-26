package com.freelas.request.event;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceRequestEvent {
    private Long requestId;
    private String serviceType;
    private Double latitude;
    private Double longitude;
}
