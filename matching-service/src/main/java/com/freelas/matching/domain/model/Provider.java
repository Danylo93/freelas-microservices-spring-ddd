package com.freelas.matching.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Provider {
    private Long id;
    private String name;
    private String serviceType;
    private Double latitude;
    private Double longitude;
}
