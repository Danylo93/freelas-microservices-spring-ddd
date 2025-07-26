package com.freelas.request.controller;

import com.freelas.request.domain.model.ServiceRequest;
import com.freelas.request.domain.service.ServiceRequestService;
import com.freelas.request.dto.ServiceRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requests")
@RequiredArgsConstructor
public class ServiceRequestController {

    private final ServiceRequestService service;

    @PostMapping
    public ResponseEntity<ServiceRequest> create(@RequestBody ServiceRequestDTO dto) {
        return ResponseEntity.ok(service.createRequest(dto));
    }
}
