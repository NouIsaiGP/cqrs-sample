package com.witenconsulting.cqrs.domain.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Document(collection = "personReadModel")
@AllArgsConstructor
@Setter
@Getter
public class PersonReadModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id; // This will map to MongoDB's _id field.
    private String name;
    private String lastName;
    @JsonSerialize(using = ToStringSerializer.class) // Ensure the date is serialized as a String
    private LocalDate birthDate;
    private String phoneNumber;

    private AddressReadModel address;
}
