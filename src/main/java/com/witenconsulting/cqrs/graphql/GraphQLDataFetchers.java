package com.witenconsulting.cqrs.graphql;

import com.witenconsulting.cqrs.model.PersonReadModel;
import com.witenconsulting.cqrs.repository.PersonReadModelRepository;
import graphql.schema.DataFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GraphQLDataFetchers {

    private final PersonReadModelRepository personReadModelRepository;

    public DataFetcher<PersonReadModel> getPersonById() {
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("id");
            return personReadModelRepository.findById(id).orElse(null);
        };
    }

    public DataFetcher<List<PersonReadModel>> getAllPersons() {
        return dataFetchingEnvironment -> personReadModelRepository.findAll();
    }
}
