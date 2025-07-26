package com.freelas.notification.domain.service;

import com.freelas.notification.event.ServiceMatchedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    public void notifyProvider(ServiceMatchedEvent event) {
        // Simula envio da notificação
        log.info("📢 Notificando prestador ID {} sobre solicitação #{} ({} a {:.2f}km)",
                event.getProviderId(),
                event.getRequestId(),
                event.getServiceType(),
                event.getDistanceKm()
        );
    }
}
