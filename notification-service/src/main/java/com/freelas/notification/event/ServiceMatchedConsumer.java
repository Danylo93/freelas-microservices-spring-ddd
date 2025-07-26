package com.freelas.notification.event;

import com.freelas.notification.domain.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServiceMatchedConsumer {

    private final NotificationService notificationService;

    @KafkaListener(topics = "service_matched", groupId = "notification-group", containerFactory = "kafkaListenerContainerFactory")
    public void consume(ServiceMatchedEvent event) {
        notificationService.notifyProvider(event);
    }
}
