package com.donadoncore.distrocontrast.contentquery.domain.tests;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Test {

    private String distro;

    private String version;

    private String date;

    private String kernel;

    private String desktopEnvironment;

    private String type;

    private String value;

}
