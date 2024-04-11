package com.witenconsulting.cqrs.command.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.witenconsulting.cqrs.command.domain.entity.Address}
 */
@Value
public class AddressDto implements Serializable {
    @NotBlank
    String street;
    @NotBlank
    String number;
    @NotBlank
    String postalCode;
}