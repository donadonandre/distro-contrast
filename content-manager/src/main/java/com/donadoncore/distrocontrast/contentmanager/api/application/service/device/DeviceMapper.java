package com.donadoncore.distrocontrast.contentmanager.api.application.service.device;

import com.donadoncore.distrocontrast.contentmanager.api.domain.device.DeviceFormRequest;
import com.donadoncore.distrocontrast.contentmanager.api.domain.device.DeviceResponse;
import com.donadoncore.distrocontrast.contentmanager.api.domain.device.Device;
import com.donadoncore.distrocontrast.contentmanager.api.domain.user.DataUserResponse;
import com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.events.dto.DeviceEventDto;
import com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.events.dto.UserDeviceEventRequest;

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
                new DataUserResponse(device.getUser().getId(), device.getUser().getEmail(), device.getUser().getName())
        );
    }

    public static UserDeviceEventRequest toEventResource(Device device) {
        return UserDeviceEventRequest.builder()
                .sharedKey(device.getUser().getSharedKey())
                .device(transformDeviceEventDto(device))
                .build();
    }

    private static DeviceEventDto transformDeviceEventDto(Device device) {
        return DeviceEventDto.builder()
                .id(device.getId())
                .brand(device.getBrand())
                .cardVideo(device.getCardVideo())
                .disk(device.getDisk())
                .model(device.getModel())
                .processor(device.getProcessor())
                .ramMemory(device.getRamMemory())
                .type(device.getType())
                .build();
    }
    
}
