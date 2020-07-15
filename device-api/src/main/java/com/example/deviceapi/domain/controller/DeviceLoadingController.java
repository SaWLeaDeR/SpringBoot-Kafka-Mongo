package com.example.deviceapi.domain.controller;

import com.example.deviceapi.domain.controller.endpoint.DeviceLoadingControllerEndpoint;
import com.example.deviceapi.domain.model.dto.DeviceDto;
import com.example.deviceapi.domain.service.DeviceLoadingService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DeviceLoadingController {

    private final DeviceLoadingService service;

    public DeviceLoadingController(DeviceLoadingService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DeviceDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(value = DeviceLoadingControllerEndpoint.GET_DEVICE)
    public ResponseEntity<DeviceDto> get(
        @PathVariable(DeviceLoadingControllerEndpoint.ID) @Valid String id) {
        return ResponseEntity.ok(service.get(id));
    }

}
