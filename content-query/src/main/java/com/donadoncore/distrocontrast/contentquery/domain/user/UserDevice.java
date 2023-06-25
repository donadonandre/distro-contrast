package com.donadoncore.distrocontrast.contentquery.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDevice {

    private Long sharedId;

    private String type;

    private String brand;

    private String model;

    private String processor;

    private String ramMemory;

    private String disk;

    private String cardVideo;
}
