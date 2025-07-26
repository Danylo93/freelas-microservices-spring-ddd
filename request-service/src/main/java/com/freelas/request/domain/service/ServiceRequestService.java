package com.freelas.request.domain.service;

import com.freelas.request.domain.model.ServiceRequest;
import com.freelas.request.domain.repository.ServiceRequestRepository;
import com.freelas.request.dto.ServiceRequestDTO;
import com.freelas.request.event.KafkaServiceRequestProducer;
import com.freelas.request.event.ServiceRequestEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceRequestService {

    private final ServiceRequestRepository repository;
    private final KafkaServiceRequestProducer producer;

    public ServiceRequest createRequest(ServiceRequestDTO dto) {
        ServiceRequest request = ServiceRequest.builder()
                .clientName(dto.getClientName())
                .serviceType(dto.getServiceType())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .status("PENDING")
                .build();

        ServiceRequest saved = repository.save(request);

        // Envia evento para Kafka
        ServiceRequestEvent event = ServiceRequestEvent.builder()
                .requestId(saved.getId())
                .serviceType(saved.getServiceType())
                .latitude(saved.getLatitude())
                .longitude(saved.getLongitude())
                .build();
        producer.publishEvent(event);

        return saved;
    }
}
