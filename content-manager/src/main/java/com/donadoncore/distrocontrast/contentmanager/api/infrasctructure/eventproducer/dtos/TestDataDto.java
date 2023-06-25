package com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.eventproducer.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestDataDto {

    private String date;

    private String type;

    private String distro;

    private String kernel;

    private String de;

    private String value;

}
