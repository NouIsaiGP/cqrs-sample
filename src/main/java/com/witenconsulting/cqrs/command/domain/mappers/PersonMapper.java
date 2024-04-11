package com.witenconsulting.cqrs.command.domain.mappers;

import com.witenconsulting.cqrs.command.domain.dto.AddressDto;
import com.witenconsulting.cqrs.command.domain.dto.PersonDto;
import com.witenconsulting.cqrs.command.domain.entity.Address;
import com.witenconsulting.cqrs.command.domain.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(source = "address", target = "address")
    PersonDto personToPersonDto(Person person);

    @Mapping(target = "address", source = "address")
    Person personDtoToPerson(PersonDto dto);

    AddressDto addressToAddressDto(Address address);
    Address addressDtoToAddress(AddressDto dto);
}
