package com.donadoncore.distrocontrast.contentmanager.api.application.service.device;

import com.donadoncore.distrocontrast.contentmanager.api.domain.device.DeviceResponse;
import com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.events.MessageProducer;
import com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.device.DeviceRepository;
import com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.user.UserRepository;
import com.donadoncore.distrocontrast.contentmanager.api.domain.device.DeviceFormRequest;
import com.donadoncore.distrocontrast.contentmanager.api.domain.device.Device;
import com.donadoncore.distrocontrast.contentmanager.api.domain.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final UserRepository userRepository;
    private final MessageProducer messageProducer;
    private final ObjectMapper objectMapper;

    @Override
    public DeviceResponse insert(Long userId, DeviceFormRequest deviceRequest) {
        var user = userRepository.findById(userId).orElseThrow();

        var device = DeviceMapper.toEntity(deviceRequest);
        device.setUser(user);
        device = deviceRepository.save(device);

        try {
            messageProducer.sendNewDeviceMessage(
                    objectMapper.writeValueAsString(
                            DeviceMapper.toEventResource(device)
                    )
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

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
