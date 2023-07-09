package com.donadoncore.distrocontrast.contentmanager.api.application.service.distro;

import com.donadoncore.distrocontrast.contentmanager.api.domain.distro.DistroFormRequest;
import com.donadoncore.distrocontrast.contentmanager.api.domain.distro.DistroResponse;

import java.util.List;

public interface DistroService {

    DistroResponse insert(DistroFormRequest request);

    DistroResponse getById(String id);
    List<DistroResponse> getByName(String name);
    List<DistroResponse> getByBasedOn(String basedOn);

}
