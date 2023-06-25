package com.donadoncore.distrocontrast.usermanager.api.infrastructure.persistence;

import com.donadoncore.distrocontrast.usermanager.api.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
