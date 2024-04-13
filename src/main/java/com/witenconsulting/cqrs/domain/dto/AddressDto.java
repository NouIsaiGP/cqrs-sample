package com.witenconsulting.cqrs.domain.dto;

import com.witenconsulting.cqrs.domain.entity.Address;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link Address}
 */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddressDto implements Serializable {
    @NotBlank
    String street;
    @NotBlank
    String number;
    @NotBlank
    String postalCode;
}