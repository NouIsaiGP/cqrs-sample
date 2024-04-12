package com.witenconsulting.cqrs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@Getter
@Setter
public class AddressReadModel {
    private String street;
    private String number;
    private String postalCode;
}
