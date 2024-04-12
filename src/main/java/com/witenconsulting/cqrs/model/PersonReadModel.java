package com.witenconsulting.cqrs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@AllArgsConstructor
@Setter
@Getter
public class PersonReadModel {
    private String id;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String phoneNumber;
    private AddressReadModel address;

    @Override
    public String toString() {
        return "PersonReadModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
                '}';
    }
}
