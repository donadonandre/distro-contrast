package com.donadoncore.distrocontrast.contentquery.infrastructure.persistence.user;

import com.donadoncore.distrocontrast.contentquery.domain.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{'sharedKey' : ?0}")
    Optional<User> findBySharedKey(String sharedKey);

}
