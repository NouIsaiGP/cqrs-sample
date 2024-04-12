package com.witenconsulting.cqrs.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class PersonReadModel {
    private String id;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String phoneNumber;
    private AddressReadModel address;
}
