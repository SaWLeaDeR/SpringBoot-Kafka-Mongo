package com.example.deviceapi.domain.controller;

import com.example.deviceapi.domain.controller.endpoint.DeviceDataControllerEndpoint;
import com.example.deviceapi.domain.model.request.DeviceDataRequest;
import com.example.deviceapi.domain.service.DeviceDataService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DeviceDataController {

    private final DeviceDataService service;

    public DeviceDataController(DeviceDataService service) {
        this.service = service;
    }


    @PostMapping(value = DeviceDataControllerEndpoint.POST_DEVICE_DATA)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> process(
        @PathVariable(DeviceDataControllerEndpoint.DEVICE_ID) @Valid String id,
        @Valid @RequestBody DeviceDataRequest request) {
        service.process(id, request);
        return ResponseEntity.ok("event has been sent");
    }

}
