package com.freelas.matching.domain.service;

import com.freelas.matching.client.ProviderClient;
import com.freelas.matching.domain.model.Provider;
import com.freelas.matching.event.ServiceMatchedEvent;
import com.freelas.matching.event.ServiceRequestEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchingService {

    private final ProviderClient providerClient;
    private final KafkaTemplate<String, ServiceMatchedEvent> kafkaTemplate;

    public void handleRequest(ServiceRequestEvent request) {
        var providers = providerClient.getProvidersByServiceType(request.getServiceType());

        Provider bestMatch = null;
        double bestDistance = Double.MAX_VALUE;

        for (Provider p : providers) {
            double distance = calculateDistance(p.getLatitude(), p.getLongitude(), request.getLatitude(), request.getLongitude());
            if (distance < bestDistance) {
                bestDistance = distance;
                bestMatch = p;
            }
        }

        if (bestMatch != null) {
            ServiceMatchedEvent event = ServiceMatchedEvent.builder()
                    .requestId(request.getRequestId())
                    .providerId(bestMatch.getId())
                    .serviceType(request.getServiceType())
                    .distanceKm(bestDistance)
                    .build();
            kafkaTemplate.send("service_matched", event);
        }
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        return Math.sqrt(Math.pow(lat1 - lat2, 2) + Math.pow(lon1 - lon2, 2)) * 111; // Aproximação
    }
}
