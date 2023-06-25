package com.donadoncore.distrocontrast.contentmanager.api.domain.test;

public record TestResponse(
        String id,
        String distroName,
        String version,
        String desktopEnvironment,
        String kernel,
        String kind,
        String value
) {
}
