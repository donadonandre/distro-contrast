package com.donadoncore.distrocontrast.contentmanager.api.application.service.device;

import com.donadoncore.distrocontrast.contentmanager.api.domain.device.DeviceFormRequest;
import com.donadoncore.distrocontrast.contentmanager.api.domain.device.DeviceResponse;
import com.donadoncore.distrocontrast.contentmanager.api.domain.events.EventKind;
import com.donadoncore.distrocontrast.contentmanager.api.domain.events.Events;
import com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.device.DeviceRepository;
import com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.events.EventsRepository;
import com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.user.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final UserRepository userRepository;
    private final EventsRepository eventsRepository;
    private final ObjectMapper objectMapper;

    @Override
    public DeviceResponse insert(Long userId, DeviceFormRequest deviceRequest) {
        var user = userRepository.findById(userId).orElseThrow();

        var device = DeviceMapper.toEntity(deviceRequest);
        device.setUser(user);
        device = deviceRepository.save(device);

        try {
            Events events = Events.builder()
                    .dateTime(LocalDateTime.now())
                    .kind(EventKind.DEVICE)
                    .isDone(Boolean.FALSE)
                    .payload(objectMapper.writeValueAsString(
                            DeviceMapper.toEventResource(device)
                    ))
                    .build();

            eventsRepository.save(events);
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
