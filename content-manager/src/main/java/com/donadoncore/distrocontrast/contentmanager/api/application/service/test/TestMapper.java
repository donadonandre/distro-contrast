package com.donadoncore.distrocontrast.contentmanager.api.application.service.test;

import com.donadoncore.distrocontrast.contentmanager.api.domain.device.Device;
import com.donadoncore.distrocontrast.contentmanager.api.domain.distro.Distro;
import com.donadoncore.distrocontrast.contentmanager.api.domain.test.Test;
import com.donadoncore.distrocontrast.contentmanager.api.domain.test.TestFormRequest;
import com.donadoncore.distrocontrast.contentmanager.api.domain.test.TestResponse;

import java.time.LocalDate;
import java.util.UUID;

public class TestMapper {

    public static Test toEntity(TestFormRequest formRequest, Device device, Distro distro) {
        return Test.builder()
                .id(UUID.randomUUID())
                .date(LocalDate.now())
                .value(formRequest.value())
                .desktopEnvironment(formRequest.desktopEnvironment())
                .kind(formRequest.kind())
                .kernel(formRequest.kernel())
                .version(formRequest.version())
                .device(device)
                .distro(distro)
                .build();
    }

    public static TestResponse toResponse(Test from) {
        return new TestResponse(
                from.getId().toString(),
                from.getDistro().getName(),
                from.getVersion(),
                from.getDesktopEnvironment(),
                from.getKernel(),
                from.getKind(),
                from.getValue()
        );
    }

}
