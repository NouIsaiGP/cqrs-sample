package com.witenconsulting.cqrs.api.service;

import com.witenconsulting.cqrs.config.RabbitMqConfig;
import com.witenconsulting.cqrs.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageSenderService {

    private final RabbitTemplate rabbitTemplate;

    public void sendPersonUpdate(PersonDto personDto) {
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTING_KEY, personDto);
    }

}
