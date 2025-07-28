package com.freelas.matching.event;

import com.freelas.matching.domain.service.MatchingService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServiceRequestConsumer {

    private final MatchingService matchingService;

    @KafkaListener(topics = "service_requested", groupId = "matching-group", containerFactory = "kafkaListenerContainerFactory")
    public void consume(ServiceRequestEvent event) {
        matchingService.handleRequest(event);
    }
}
