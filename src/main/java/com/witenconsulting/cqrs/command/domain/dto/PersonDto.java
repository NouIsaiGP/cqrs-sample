package com.witenconsulting.cqrs.command.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.witenconsulting.cqrs.command.domain.entity.Person}
 */
@Value
public class PersonDto implements Serializable {
    @NotBlank
    String name;
    @NotBlank
    String lastName;
    @PastOrPresent
    LocalDate birthDate;
    @Size(min = 10, max = 20)
    @NotBlank
    String phoneNumber;
    @NotNull
    AddressDto address;
}