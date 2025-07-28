package com.freelas.request.event;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaServiceRequestProducer {

    private final KafkaTemplate<String, ServiceRequestEvent> kafkaTemplate;
    private static final String TOPIC = "service_requested";

    public void publishEvent(ServiceRequestEvent event) {
        kafkaTemplate.send(TOPIC, event);
    }
}
