package com.donadoncore.distrocontrast.contentmanager.api.application.service.user;

import com.donadoncore.distrocontrast.contentmanager.api.domain.device.DeviceFormRequest;
import com.donadoncore.distrocontrast.contentmanager.api.domain.user.User;
import com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User insertDevice(String userId, DeviceFormRequest formRequest) {
        var user = userRepository.findById(userId).orElseThrow();

        if (userRepository.existsDeviceByNameAndUserId(user.getId(), formRequest.name())) {
            throw new RuntimeException();
        }

        user.getDevices().add(UserMapper.toDeviceEntity(formRequest));
        userRepository.save(user);
        // return UserMapper.toDeviceResponse(user.getDevices().get(user.getDevices().size()-1));
        return user;
    }
}
