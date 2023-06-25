package com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.web.events.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserDeviceEventRequest {

    private String sharedKey;

    private DeviceEventDto device;

}
