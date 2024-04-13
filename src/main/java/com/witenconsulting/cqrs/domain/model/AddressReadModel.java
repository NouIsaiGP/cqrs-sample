package com.witenconsulting.cqrs.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@Document
@AllArgsConstructor
@Getter
@Setter
public class AddressReadModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String street;
    private String number;
    private String postalCode;
}
