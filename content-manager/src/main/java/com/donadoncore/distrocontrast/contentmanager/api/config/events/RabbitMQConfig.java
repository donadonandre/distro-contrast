package com.donadoncore.distrocontrast.contentmanager.api.config.events;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${events.resource.queues.new-device-queue}")
    private String topicNewDeviceName;

    @Value("${events.resource.queues.tests-queue}")
    private String topicTestsName;

    @Bean
    public TopicExchange topicNewDevice() { return new TopicExchange(topicNewDeviceName); }

    @Bean
    public TopicExchange topicTests() { return new TopicExchange(topicTestsName); }
}
