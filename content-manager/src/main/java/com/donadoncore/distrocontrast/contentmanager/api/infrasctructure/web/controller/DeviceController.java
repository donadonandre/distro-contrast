package com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.web.controller;

import com.donadoncore.distrocontrast.contentmanager.api.application.service.device.DeviceService;
import com.donadoncore.distrocontrast.contentmanager.api.domain.device.DeviceResponse;
import com.donadoncore.distrocontrast.contentmanager.api.domain.device.DeviceFormRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("devices")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @PostMapping
    @Transactional
    public ResponseEntity insert(
            @RequestHeader Long userId,
            @RequestBody DeviceFormRequest deviceFormRequest,
            UriComponentsBuilder uriBuilder
            ) {
        var response = deviceService.insert(userId, deviceFormRequest);
        var uri = uriBuilder.path("/devices/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    public ResponseEntity getAll(
            @RequestHeader Long userId
    ) {
        return ResponseEntity.ok(deviceService.getAll(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(deviceService.getById(id));
    }

}
