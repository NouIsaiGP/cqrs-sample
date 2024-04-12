package com.witenconsulting.cqrs.dto;

import com.witenconsulting.cqrs.entity.Person;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Person}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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