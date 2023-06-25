package com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.distro;

import com.donadoncore.distrocontrast.contentmanager.api.domain.distro.Distro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistroRepository extends JpaRepository<Distro, Long> {

    List<Distro> findByName(String name);

    @Query(
            value = "SELECT * FROM distro WHERE based_on LIKE '%?%'", nativeQuery = true
    )
    List<Distro> findByBasedOn(String basedOn);

}
