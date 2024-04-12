package com.witenconsulting.cqrs.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String QUEUE = "cqrs_queue";
    public static final String EXCHANGE = "cqrs_exchange";
    public static final String ROUTING_KEY = "cqrs_routingKey";

    @Bean
    Queue queue() {
        return new Queue(QUEUE, true);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

}
