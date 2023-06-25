package com.donadoncore.distrocontrast.contentquery.application.tests;

import com.donadoncore.distrocontrast.contentquery.domain.tests.*;

import java.util.List;
import java.util.stream.Collectors;

public class TestsMapper {

    public static List<Test> toEntity(List<TestDto> dtoList) {
        return dtoList.stream().map(dto -> Test.builder()
                        .date(dto.getDate())
                        .distro(dto.getDistro())
                        .version(dto.getVersion())
                        .kernel(dto.getKernel())
                        .desktopEnvironment(dto.getDe())
                        .type(dto.getType())
                        .value(dto.getValue())
                        .build())
                .collect(Collectors.toList());
    }

    public static TestsDocument toDocumentFrom(DeviceMessage message) {
        return TestsDocument.builder()
                .device(TestDeviceMapper.toTestDevice(message.getDevice()))
                .user(new TestUser(message.getRelatedId(), message.getUserName()))
                // .tests(toEntity(message.getTests()))
                .build();
    }

}
