package com.freelas.matching.client;

import com.freelas.matching.domain.model.Provider;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProviderClient {

    private final WebClient.Builder webClientBuilder;

    public List<Provider> getProvidersByServiceType(String serviceType) {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/providers/by-service-type?type=" + serviceType)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Provider>>() {})
                .block();
    }
}
