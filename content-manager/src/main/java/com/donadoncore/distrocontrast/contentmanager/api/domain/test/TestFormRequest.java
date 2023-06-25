package com.donadoncore.distrocontrast.contentmanager.api.domain.test;

public record TestFormRequest(
        Long distroId,
        String version,
        String desktopEnvironment,
        String kernel,
        String kind,
        String value
) {
}
