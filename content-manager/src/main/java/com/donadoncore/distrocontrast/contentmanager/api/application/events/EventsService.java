package com.donadoncore.distrocontrast.contentmanager.api.application.events;

import com.donadoncore.distrocontrast.contentmanager.api.domain.events.Events;
import com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.events.EventsRepository;
import com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.web.events.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventsService {

    private final EventsRepository eventsRepository;
    private final MessageProducer messageProducer;

    public void execute() {
        List<Events> byIsDone = eventsRepository.findByIsDone(Boolean.FALSE);

        for (Events events : byIsDone) {

        }
    }

}
