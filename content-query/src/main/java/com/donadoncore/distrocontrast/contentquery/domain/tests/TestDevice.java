package com.donadoncore.distrocontrast.contentquery.domain.tests;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TestDevice {

    private Long relatedId;

    private String type;

    private String brand;

    private String model;

    private String processor;

    private String ramMemory;

    private String disk;

    private String cardVideo;

}
