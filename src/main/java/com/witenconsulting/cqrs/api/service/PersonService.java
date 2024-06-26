package com.witenconsulting.cqrs.api.service;

import com.witenconsulting.cqrs.config.RabbitMqConfig;
import com.witenconsulting.cqrs.domain.dto.PersonDto;
import com.witenconsulting.cqrs.domain.entity.Person;
import com.witenconsulting.cqrs.mappers.PersonMapper;
import com.witenconsulting.cqrs.repository.PersonRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final RabbitTemplate rabbitTemplate;

    @Transactional
    public PersonDto createPerson(@Valid PersonDto dto) {
        Person person = personRepository.save(PersonMapper.INSTANCE.personDtoToPerson(dto));
        var personDto = PersonMapper.INSTANCE.personToPersonDto(person);
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTING_KEY, personDto);
        return personDto;
    }

    public PersonDto updatePerson(@Valid PersonDto dto, Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        person.setName(dto.getName());
        person.setLastName(dto.getLastName());
        person.setBirthDate(dto.getBirthDate());
        person.setPhoneNumber(dto.getPhoneNumber());

        person.getAddress().setNumber(dto.getAddress().getNumber());
        person.getAddress().setStreet(dto.getAddress().getStreet());
        person.getAddress().setPostalCode(dto.getAddress().getPostalCode());

        Person personSaved = personRepository.save(person);

        return PersonMapper.INSTANCE.personToPersonDto(personSaved);
    }

}
