package com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.distro;

import com.donadoncore.distrocontrast.contentmanager.api.domain.distro.Distro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistroRepository extends MongoRepository<Distro, String> {

    @Query("{ 'name' :  ?0 }")
    List<Distro> findByName(String name);

    @Query("{ 'basedOn' : { $in: ?0 } }")
    List<Distro> findByBasedOn(String basedOn);

}
