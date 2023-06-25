package com.donadoncore.distrocontrast.contentquery.infrastructure.eventconsumer;

import com.donadoncore.distrocontrast.contentquery.domain.tests.DeviceMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.donadoncore.distrocontrast.contentquery.application.tests.TestsService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageConsumer {

    private final TestsService testsService;

    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "${content.creator.event.consumer.queue.name}")
    @Scheduled(fixedRate = 900_000)
    public void receiveMessage(byte[] message) {
        try {
            String jsonMessage = new String(message);
            DeviceMessage dto = objectMapper.readValue(jsonMessage, DeviceMessage.class);

            testsService.insertTest(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
