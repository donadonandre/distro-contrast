package com.donadoncore.distrocontrast.contentmanager.api.application.service.device;

import com.donadoncore.distrocontrast.contentmanager.api.application.service.user.UserMapper;
import com.donadoncore.distrocontrast.contentmanager.api.domain.device.DeviceFormRequest;
import com.donadoncore.distrocontrast.contentmanager.api.domain.device.DeviceResponse;
import com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.device.DeviceRepository;
import com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.events.EventsRepository;
import com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.user.UserRepository;
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
    private final EventsRepository eventsRepository;
    private final ObjectMapper objectMapper;

    @Override
    public DeviceResponse insert(String userId, DeviceFormRequest deviceRequest) {
        var user = userRepository.findById(userId).orElseThrow();

        if (!userRepository.existsDeviceByNameAndUserId(user.getId(), deviceRequest.name())) {
            user.getDevices().add(UserMapper.toDeviceEntity(deviceRequest));
        }


//        try {
//            Events events = Events.builder()
//                    .dateTime(LocalDateTime.now())
//                    .kind(EventKind.DEVICE)
//                    .isDone(Boolean.FALSE)
//                    .payload(objectMapper.writeValueAsString(
//                            DeviceMapper.toEventResource(device)
//                    ))
//                    .build();
//
//            eventsRepository.save(events);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }

        return UserMapper.toDeviceResponse(device);
    }

    @Override
    public DeviceResponse getById(Long id) {
        return deviceRepository.findById(id).map(UserMapper::toDeviceResponse).orElseThrow();
    }

    @Override
    public List<DeviceResponse> getAll(Long userId) {
        return deviceRepository.findAllDevicesByUserId(userId).stream()
                .map(UserMapper::toDeviceResponse).collect(Collectors.toList());
    }
}
