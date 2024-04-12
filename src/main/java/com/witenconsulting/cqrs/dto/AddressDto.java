package com.witenconsulting.cqrs.dto;

import com.witenconsulting.cqrs.entity.Address;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Address}
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