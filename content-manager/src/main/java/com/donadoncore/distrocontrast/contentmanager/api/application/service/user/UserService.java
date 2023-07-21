package com.donadoncore.distrocontrast.contentmanager.api.application.service.user;

import com.donadoncore.distrocontrast.contentmanager.api.domain.device.DeviceFormRequest;
import com.donadoncore.distrocontrast.contentmanager.api.domain.user.User;

public interface UserService {

    User insertDevice(String userId, DeviceFormRequest formRequest);

}
