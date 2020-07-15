package com.example.deviceapi.domain.controller;

import com.example.deviceapi.domain.controller.endpoint.DeviceLoadingControllerEndpoint;
import com.example.deviceapi.domain.controller.endpoint.DeviceUpdatingControllerEndpoint;
import com.example.deviceapi.domain.model.dto.DeviceDto;
import com.example.deviceapi.domain.model.request.CreateDeviceRequest;
import com.example.deviceapi.domain.model.request.UpdateDeviceRequest;
import com.example.deviceapi.domain.service.DeviceUpdatingService;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DeviceUpdatingController {

    private final DeviceUpdatingService service;

    public DeviceUpdatingController(DeviceUpdatingService service) {
        this.service = service;
    }

    @PostMapping(value = DeviceUpdatingControllerEndpoint.CREATE_DEVICE)
    public ResponseEntity<DeviceDto> create(
        @Valid @RequestBody CreateDeviceRequest request) {
        return ResponseEntity.ok(service.save(request));
    }

    @PutMapping(value = DeviceUpdatingControllerEndpoint.UPDATE_DEVICE)
    public ResponseEntity<DeviceDto> update(
        @PathVariable(DeviceLoadingControllerEndpoint.ID) @Valid String id,
        @Valid @RequestBody UpdateDeviceRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }
}
