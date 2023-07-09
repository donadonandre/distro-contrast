package com.donadoncore.distrocontrast.contentmanager.api.application.service.device;

import com.donadoncore.distrocontrast.contentmanager.api.domain.device.DeviceResponse;
import com.donadoncore.distrocontrast.contentmanager.api.domain.device.DeviceFormRequest;

import java.util.List;

public interface DeviceService {

    DeviceResponse insert(String userId, DeviceFormRequest deviceRequest);
    DeviceResponse getById(String id);
    List<DeviceResponse> getAll(Long userId);

}
