package com.freelas.provider.mapper;

import com.freelas.provider.domain.model.Provider;
import com.freelas.provider.dto.ProviderRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class ProviderMapper {

    public Provider toEntity(ProviderRequestDTO dto) {
        return Provider.builder()
                .name(dto.getName())
                .serviceType(dto.getServiceType())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .build();
    }
}
