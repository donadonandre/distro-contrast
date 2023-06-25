package com.donadoncore.distrocontrast.contentmanager.api.domain.distro;

import java.util.List;

public record DistroFormRequest(
        String name,
        List<String> basedOn
) {
}
