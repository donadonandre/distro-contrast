package com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.web.controller;

import com.donadoncore.distrocontrast.contentmanager.api.application.service.distro.DistroService;
import com.donadoncore.distrocontrast.contentmanager.api.domain.distro.DistroFormRequest;
import com.donadoncore.distrocontrast.contentmanager.api.domain.distro.DistroResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("distros")
public class DistroController {

    private final DistroService distroService;

    @PostMapping
    public ResponseEntity insert(@RequestBody DistroFormRequest formRequest, UriComponentsBuilder uriBuilder) {
        var response = distroService.insert(formRequest);
        var uri = uriBuilder.path("/distros/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(distroService.getById(id));
    }

    @GetMapping("/name")
    public ResponseEntity getByName(
            @RequestParam String name
    ) {
        return ResponseEntity.ok(distroService.getByName(name));
    }

    @GetMapping("/based-on")
    public ResponseEntity getByBasedOn(
            @RequestParam String basedOn
    ) {
        return ResponseEntity.ok(distroService.getByBasedOn(basedOn));
    }

}
