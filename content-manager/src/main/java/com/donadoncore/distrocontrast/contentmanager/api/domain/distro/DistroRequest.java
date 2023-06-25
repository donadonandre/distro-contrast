package com.donadoncore.distrocontrast.contentmanager.api.domain.distro;

import java.util.List;

public record DistroRequest(
        String name,

        List<String> basedOn
) {
}
