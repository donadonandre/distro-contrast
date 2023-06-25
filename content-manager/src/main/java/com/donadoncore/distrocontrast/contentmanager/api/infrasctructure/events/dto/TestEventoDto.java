package com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.events.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class TestEventoDto {
    private LocalDate date;

    private String distro;

    private String version;

    private String desktopEnvironment;

    private String kernel;

    private String kind;

    private String value;
}
