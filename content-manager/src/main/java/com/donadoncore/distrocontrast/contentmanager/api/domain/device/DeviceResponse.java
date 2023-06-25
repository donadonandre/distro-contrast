package com.donadoncore.distrocontrast.contentmanager.api.domain.device;

import com.donadoncore.distrocontrast.contentmanager.api.domain.user.DataUserRespose;

public record DeviceResponse(
        Long id,
        String type,
        String brand,

        String model,

        String processor,

        String ramMemory,

        String disk,

        String cardVideo,

        DataUserRespose user
) {}
