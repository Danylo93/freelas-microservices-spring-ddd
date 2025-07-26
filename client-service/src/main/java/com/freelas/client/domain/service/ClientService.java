package com.freelas.client.domain.service;

import com.freelas.client.domain.model.Client;
import com.freelas.client.domain.repository.ClientRepository;
import com.freelas.client.dto.ClientRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    public Client register(ClientRequestDTO dto) {
        Client client = Client.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .build();
        return repository.save(client);
    }
}
