package com.donadoncore.distrocontrast.contentmanager.api.application.service.test;

import com.donadoncore.distrocontrast.contentmanager.api.domain.test.TestFormRequest;
import com.donadoncore.distrocontrast.contentmanager.api.domain.test.TestResponse;
import com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.device.DeviceRepository;
import com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.distro.DistroRepository;
import com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.test.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;
    private final DeviceRepository deviceRepository;
    private final DistroRepository distroRepository;

    @Override
    public TestResponse insert(Long deviceId, TestFormRequest formRequest) {
        var device = deviceRepository.findById(deviceId).orElseThrow();
        var distro = distroRepository.findById(formRequest.distroId()).orElseThrow();

        var test = TestMapper.toEntity(formRequest, device, distro);
        test = testRepository.save(test);
        return TestMapper.toResponse(test);
    }

    @Override
    public TestResponse getById(String id) {
        return null;
    }

    @Override
    public List<TestResponse> getByDeviceId(Long deviceId) {
        return null;
    }

    @Override
    public List<TestResponse> getByDistro(String distroName) {
        return null;
    }
}
