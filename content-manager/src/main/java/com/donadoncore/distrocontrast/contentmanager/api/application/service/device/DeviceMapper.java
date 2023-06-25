package com.donadoncore.distrocontrast.contentmanager.api.application.service.device;

import com.donadoncore.distrocontrast.contentmanager.api.domain.device.DeviceFormRequest;
import com.donadoncore.distrocontrast.contentmanager.api.domain.device.DeviceResponse;
import com.donadoncore.distrocontrast.contentmanager.api.domain.device.Device;
import com.donadoncore.distrocontrast.contentmanager.api.domain.user.DataUserRespose;

public class DeviceMapper {
    
    public static Device toEntity(DeviceFormRequest dto) {
        return Device.builder()
                .type(dto.type())
                .brand(dto.brand())
                .model(dto.model())
                .processor(dto.processor())
                .ramMemory(dto.ramMemory())
                .disk(dto.disk())
                .cardVideo(dto.cardVideo())
                .build();
    }
    
    public static DeviceResponse toResponseDto(Device device) {
        return new DeviceResponse(
                device.getId(),
                device.getType().toString(),
                device.getBrand(),
                device.getModel(),
                device.getProcessor(),
                device.getRamMemory(),
                device.getDisk(),
                device.getCardVideo(),
                new DataUserRespose(device.getUser().getId(), device.getUser().getEmail(), device.getUser().getName())
        );
    }
    
}
