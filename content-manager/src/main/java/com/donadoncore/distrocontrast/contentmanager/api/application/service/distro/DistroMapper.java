package com.donadoncore.distrocontrast.contentmanager.api.application.service.distro;

import com.donadoncore.distrocontrast.contentmanager.api.domain.distro.Distro;
import com.donadoncore.distrocontrast.contentmanager.api.domain.distro.DistroFormRequest;
import com.donadoncore.distrocontrast.contentmanager.api.domain.distro.DistroResponse;

import java.util.List;

public class DistroMapper {

    public static Distro toEntity(DistroFormRequest formRequest) {
        return Distro.builder().build();
    }

    public static DistroResponse toResponse(Distro distro) {
        return new DistroResponse(0L, " ", List.of());
    }

}
