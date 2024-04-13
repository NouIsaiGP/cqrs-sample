package com.witenconsulting.cqrs.mappers;

import com.witenconsulting.cqrs.domain.dto.AddressDto;
import com.witenconsulting.cqrs.domain.dto.PersonDto;
import com.witenconsulting.cqrs.domain.entity.Address;
import com.witenconsulting.cqrs.domain.entity.Person;
import com.witenconsulting.cqrs.domain.model.AddressReadModel;
import com.witenconsulting.cqrs.domain.model.PersonReadModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDto personToPersonDto(Person person);

    Person personDtoToPerson(PersonDto dto);

    AddressDto addressToAddressDto(Address address);
    Address addressDtoToAddress(AddressDto dto);

    // Asegurándonos de que el mapeo entre AddressDto y AddressReadModel está bien configurado
    @Mapping(source = "address", target = "address", qualifiedByName = "addressDtoToAddressReadModel")
    PersonReadModel personDtoToPersonReadModel(PersonDto personDto);

    // Método con anotación @Named para el mapeo de dirección
    @Named("addressDtoToAddressReadModel")
    AddressReadModel addressDtoToAddressReadModel(AddressDto addressDto);
}