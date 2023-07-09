package com.donadoncore.distrocontrast.contentmanager.api.domain.device;

import com.donadoncore.distrocontrast.contentmanager.api.domain.user.DataUserResponse;

public record DeviceResponse(
        String id,
        String name,
        String type,
        String brand,
        String model,
        String processor,
        String ramMemory,
        String disk,
        String cardVideo
) {}
