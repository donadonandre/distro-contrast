package com.donadoncore.distrocontrast.contentmanager.api.domain.distro;

import java.util.List;

public record DistroResponse(
        String id,
        String name,
        List<String> basedOn

) {
}
