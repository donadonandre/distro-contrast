package com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.web.controller;

import com.donadoncore.distrocontrast.contentmanager.api.application.service.test.TestService;
import com.donadoncore.distrocontrast.contentmanager.api.domain.test.TestFormRequest;
import com.donadoncore.distrocontrast.contentmanager.api.domain.test.TestResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("tests")
public class TestController {

    private final TestService testService;

    @PostMapping
    @Transactional
    public ResponseEntity insert (
            @RequestHeader Long deviceId,
            @RequestBody TestFormRequest formRequest,
            UriComponentsBuilder uriBuilder
            ) {
        TestResponse response = testService.insert(deviceId, formRequest);
        var uri = uriBuilder.path("/tests/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable String id) {
        return ResponseEntity.ok(testService.getById(id));
    }

    @GetMapping("/device")
    public ResponseEntity getByDeviceId(@RequestHeader Long deviceId) {
        return ResponseEntity.ok(testService.getByDeviceId(deviceId));
    }

    @GetMapping("/distro")
    public ResponseEntity getByDistro(@RequestParam String distroName) {
        return ResponseEntity.ok(testService.getByDistro(distroName));
    }
}
