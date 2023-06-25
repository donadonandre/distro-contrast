package com.donadoncore.distrocontrast.contentquery.domain.device;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeviceDto {

    private Long id;

    private String type;

    private String brand;

    private String model;

    private String processor;

    private String ramMemory;

    private String disk;

    private String cardVideo;

}
