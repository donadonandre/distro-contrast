package com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.events;

import com.donadoncore.distrocontrast.contentmanager.api.domain.events.Events;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventsRepository extends JpaRepository<Events, LocalDateTime> {

    List<Events> findByIsDone(Boolean status);

}
