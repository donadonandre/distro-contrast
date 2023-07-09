package com.donadoncore.distrocontrast.contentmanager.api.domain.device;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    private String sharedId;

    private DeviceType type;

    private String name;

    private String brand;

    private String model;

    private String processor;

    private String ramMemory;

    private String disk;

    private String cardVideo;
}
