package com.witenconsulting.cqrs.mappers;

import com.witenconsulting.cqrs.dto.AddressDto;
import com.witenconsulting.cqrs.dto.PersonDto;
import com.witenconsulting.cqrs.entity.Address;
import com.witenconsulting.cqrs.entity.Person;
import com.witenconsulting.cqrs.model.AddressReadModel;
import com.witenconsulting.cqrs.model.PersonReadModel;
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

    @Mapping(source = "address", target = "address")
    PersonReadModel personDtoToPersonReadModel(PersonDto personDto);

    AddressReadModel addressDtoToAddressReadModel(AddressDto addressDto);
}
