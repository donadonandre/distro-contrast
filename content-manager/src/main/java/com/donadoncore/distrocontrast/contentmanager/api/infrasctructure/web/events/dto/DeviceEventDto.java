package com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.web.events.dto;

import com.donadoncore.distrocontrast.contentmanager.api.domain.device.DeviceType;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DeviceEventDto {
    private Long id;

    private DeviceType type;

    private String brand;

    private String model;

    private String processor;

    private String ramMemory;

    private String disk;

    private String cardVideo;

}
