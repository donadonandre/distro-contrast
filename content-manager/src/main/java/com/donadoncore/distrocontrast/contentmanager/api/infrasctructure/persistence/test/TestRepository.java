package com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.test;

import com.donadoncore.distrocontrast.contentmanager.api.domain.test.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
}
