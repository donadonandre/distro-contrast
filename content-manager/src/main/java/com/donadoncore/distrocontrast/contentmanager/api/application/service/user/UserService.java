package com.donadoncore.distrocontrast.contentmanager.api.application.service.user;

import com.donadoncore.distrocontrast.contentmanager.api.domain.device.DeviceFormRequest;
import com.donadoncore.distrocontrast.contentmanager.api.domain.device.DeviceResponse;

public interface UserService {

    DeviceResponse insertDevice(String userId, DeviceFormRequest formRequest);

}
