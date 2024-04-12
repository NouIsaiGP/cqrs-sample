package com.witenconsulting.cqrs.api.service;

import com.witenconsulting.cqrs.dto.PersonDto;
import com.witenconsulting.cqrs.entity.Person;
import com.witenconsulting.cqrs.mappers.PersonMapper;
import com.witenconsulting.cqrs.repository.PersonRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional
    public PersonDto createPerson(@Valid PersonDto dto) {
        Person person = personRepository.save(PersonMapper.INSTANCE.personDtoToPerson(dto));
        return PersonMapper.INSTANCE.personToPersonDto(person);
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
