package com.witenconsulting.cqrs.repository;

import com.witenconsulting.cqrs.domain.model.PersonReadModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonReadModelRepository extends MongoRepository<PersonReadModel, String> {
}
