package com.donadoncore.distrocontrast.contentmanager.api.application.service.distro;

import com.donadoncore.distrocontrast.contentmanager.api.domain.distro.Distro;
import com.donadoncore.distrocontrast.contentmanager.api.domain.distro.DistroFormRequest;
import com.donadoncore.distrocontrast.contentmanager.api.domain.distro.DistroResponse;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class DistroMapper {

    public static Distro toEntity(DistroFormRequest formRequest) {
        StringJoiner joiner = new StringJoiner(",");
        for (var distroBase : formRequest.basedOn()) {
            joiner.add(distroBase);
        }

        return Distro.builder()
                .name(formRequest.name())
                .basedOn(joiner.toString())
                .build();
    }

    public static DistroResponse toResponse(Distro distro) {
        return new DistroResponse(distro.getId(), distro.getName(), Arrays.asList(distro.getBasedOn().split(",")));
    }

}
