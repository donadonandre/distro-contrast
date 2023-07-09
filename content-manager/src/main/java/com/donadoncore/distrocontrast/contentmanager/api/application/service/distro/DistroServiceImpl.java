package com.donadoncore.distrocontrast.contentmanager.api.application.service.distro;

import com.donadoncore.distrocontrast.contentmanager.api.domain.distro.DistroResponse;
import com.donadoncore.distrocontrast.contentmanager.api.domain.distro.Distro;
import com.donadoncore.distrocontrast.contentmanager.api.domain.distro.DistroFormRequest;
import com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.distro.DistroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DistroServiceImpl implements DistroService {

    private final DistroRepository distroRepository;

    @Override
    public DistroResponse insert(DistroFormRequest request) {
        var distro = DistroMapper.toEntity(request);
        distro = distroRepository.save(distro);
        return DistroMapper.toResponse(distro);
    }

    @Override
    public DistroResponse getById(String id) {
        return distroRepository.findById(id).map(DistroMapper::toResponse).orElseThrow();
    }

    @Override
    public List<DistroResponse> getByName(String name) {
        return distroRepository.findByName(name).stream().map(DistroMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public List<DistroResponse> getByBasedOn(String basedOn) {
        return distroRepository.findByBasedOn(basedOn).stream().map(DistroMapper::toResponse).collect(Collectors.toList());
    }
}
