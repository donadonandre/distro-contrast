package com.donadoncore.distrocontrast.contentmanager.api.domain.device;

import com.donadoncore.distrocontrast.contentmanager.api.domain.user.DataUserResponse;

public record DeviceResponse(
        Long id,
        String type,
        String brand,

        String model,

        String processor,

        String ramMemory,

        String disk,

        String cardVideo,

        DataUserResponse user
) {}
