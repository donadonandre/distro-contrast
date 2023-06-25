package com.donadoncore.distrocontrast.contentquery.application.tests;

import com.donadoncore.distrocontrast.contentquery.domain.device.DeviceDto;
import com.donadoncore.distrocontrast.contentquery.domain.tests.TestDevice;

public class TestDeviceMapper {

    public static TestDevice toTestDevice(DeviceDto dto) {
        return TestDevice.builder()
                .brand(dto.getBrand())
                .relatedId(dto.getId())
                .type(dto.getType())
                .cardVideo(dto.getCardVideo())
                .disk(dto.getDisk())
                .model(dto.getModel())
                .processor(dto.getProcessor())
                .ramMemory(dto.getRamMemory())
                .build();
    }

}
