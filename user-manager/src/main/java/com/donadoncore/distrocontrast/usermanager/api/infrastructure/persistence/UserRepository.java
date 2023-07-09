package com.donadoncore.distrocontrast.usermanager.api.infrastructure.persistence;

import com.donadoncore.distrocontrast.usermanager.api.domain.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
}
