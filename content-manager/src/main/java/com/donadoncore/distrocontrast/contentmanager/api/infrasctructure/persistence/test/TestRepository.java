package com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.test;

import com.donadoncore.distrocontrast.contentmanager.api.domain.test.Test;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends MongoRepository<Test, String> {
}
