package com.witenconsulting.cqrs.events;

import com.witenconsulting.cqrs.config.RabbitMqConfig;
import com.witenconsulting.cqrs.domain.dto.PersonDto;
import com.witenconsulting.cqrs.mappers.PersonMapper;
import com.witenconsulting.cqrs.domain.model.PersonReadModel;
import com.witenconsulting.cqrs.repository.PersonReadModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonUpdateListener {

    private final PersonReadModelRepository personReadModelRepository;

    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void receiveMessage(@Payload PersonDto personDto) {
        PersonReadModel personReadModel = PersonMapper.INSTANCE.personDtoToPersonReadModel(personDto);
        personReadModelRepository.save(personReadModel);
    }

}
