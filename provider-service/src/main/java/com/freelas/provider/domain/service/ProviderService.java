package com.freelas.provider.domain.service;

import com.freelas.provider.domain.model.Provider;
import com.freelas.provider.domain.repository.ProviderRepository;
import com.freelas.provider.dto.ProviderRequestDTO;
import com.freelas.provider.mapper.ProviderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProviderService {

    private final ProviderRepository repository;
    private final ProviderMapper mapper;

    public Provider createProvider(ProviderRequestDTO dto) {
        // Aqui poderíamos aplicar validações de negócio
        Provider provider = mapper.toEntity(dto);
        return repository.save(provider);
    }
}
