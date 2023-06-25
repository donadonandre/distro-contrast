package com.donadoncore.distrocontrast.contentmanager.api.application.service.device;

import com.donadoncore.distrocontrast.contentmanager.api.domain.device.DeviceResponse;
import com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.device.DeviceRepository;
import com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.user.UserRepository;
import com.donadoncore.distrocontrast.contentmanager.api.domain.device.DeviceFormRequest;
import com.donadoncore.distrocontrast.contentmanager.api.domain.device.Device;
import com.donadoncore.distrocontrast.contentmanager.api.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final UserRepository userRepository;

    @Override
    public DeviceResponse insert(Long userId, DeviceFormRequest deviceRequest) {
        User user = userRepository.findById(userId).orElseThrow();

        Device device = DeviceMapper.toEntity(deviceRequest);
        device.setUser(user);
        device = deviceRepository.save(device);
        return DeviceMapper.toResponseDto(device);
    }

    @Override
    public DeviceResponse getById(Long id) {
        return deviceRepository.findById(id).map(DeviceMapper::toResponseDto).orElseThrow();
    }

    @Override
    public List<DeviceResponse> getAll(Long userId) {
        return deviceRepository.findAllDevicesByUserId(userId).stream()
                .map(DeviceMapper::toResponseDto).collect(Collectors.toList());
    }
}
