package com.witenconsulting.cqrs.graphql;


import com.witenconsulting.cqrs.domain.model.PersonReadModel;
import com.witenconsulting.cqrs.repository.PersonReadModelRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final PersonReadModelRepository repository;

    public Iterable<PersonReadModel> findAll() {
        return repository.findAll();
    }
}
