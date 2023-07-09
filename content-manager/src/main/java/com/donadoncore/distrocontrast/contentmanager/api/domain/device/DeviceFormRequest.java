package com.donadoncore.distrocontrast.contentmanager.api.domain.device;

public record DeviceFormRequest(
        String name,
        DeviceType type,
        String brand,
        String model,
        String processor,
        String ramMemory,
        String disk,
        String cardVideo
) {

}
