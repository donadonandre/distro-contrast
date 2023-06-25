package com.donadoncore.distrocontrast.contentquery.domain.tests;

import com.donadoncore.distrocontrast.contentquery.domain.device.DeviceDto;
import lombok.Data;

@Data
public class DeviceMessage {

    private Long relatedId;

    private String userName;

    private DeviceDto device;
}
