package com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.eventproducer.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TestsMessageDto {

    private String userId;

    private String roadMapId;

    private String device;

    private List<TestDataDto> tests;
}
