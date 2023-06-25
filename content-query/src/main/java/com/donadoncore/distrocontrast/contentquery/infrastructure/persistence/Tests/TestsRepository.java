package com.donadoncore.distrocontrast.contentquery.infrastructure.persistence.Tests;

import com.donadoncore.distrocontrast.contentquery.domain.tests.TestsDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestsRepository extends MongoRepository<TestsDocument, String> {

    @Query("{'user.relatedId' : ?0, 'device.relatedId' : ?1}")
    Optional<TestsDocument> findByUserAndDevice(Long userId, Long deviceId);

}
