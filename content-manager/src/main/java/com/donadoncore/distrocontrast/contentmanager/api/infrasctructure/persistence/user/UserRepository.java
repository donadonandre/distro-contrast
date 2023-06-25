package com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.user;

import com.donadoncore.distrocontrast.contentmanager.api.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
