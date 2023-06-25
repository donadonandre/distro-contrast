package com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.events;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;
    @Qualifier(value = "topicNewDevice")
    private final TopicExchange newDeviceTopic;
    @Qualifier(value = "topicTests")
    private final TopicExchange testsTopic;

    public void sendNewDeviceMessage(String message) {
        rabbitTemplate.convertAndSend(newDeviceTopic.getName(), queue.getName(), message);
    }

    public void sendTestsMessage(String message) {
        rabbitTemplate.convertAndSend(testsTopic.getName(), queue.getName(), message);
    }

}
