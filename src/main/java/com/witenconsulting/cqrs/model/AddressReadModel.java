package com.witenconsulting.cqrs.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AddressReadModel {
    private String street;
    private String number;
    private String postalCode;
}
