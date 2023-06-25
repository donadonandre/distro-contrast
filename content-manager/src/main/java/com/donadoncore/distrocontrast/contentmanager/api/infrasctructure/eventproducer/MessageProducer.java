package com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.eventproducer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class  MessageProducer {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public void sendMessage(String message) {
        // testsMessageService.

        rabbitTemplate.convertAndSend(queue.getName(), message);
    }
}
