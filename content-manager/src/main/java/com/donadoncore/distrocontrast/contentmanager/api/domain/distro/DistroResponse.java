package com.donadoncore.distrocontrast.contentmanager.api.domain.distro;

import java.util.List;

public record DistroResponse(
        Long id,
        String name,
        List<String> basedOn

) {
}
