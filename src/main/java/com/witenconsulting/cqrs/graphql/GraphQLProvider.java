package com.witenconsulting.cqrs.graphql;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;

@Component
@RequiredArgsConstructor
@Qualifier("graphqlProvider")
public class GraphQLProvider {
    private final ApplicationContext applicationContext;
    private final GraphQLDataFetchers graphQLDataFetchers;

    @Bean
    public GraphQL graphQL() throws IOException {
        Resource resource = applicationContext.getResource("classpath:graphql/schema.graphqls");
        String sdl = new String(Files.readAllBytes(resource.getFile().toPath()));
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        return GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", builder -> builder
                        .dataFetcher("findPersonById", graphQLDataFetchers.getPersonById())
                        .dataFetcher("findAllPersons", graphQLDataFetchers.getAllPersons()))
                .build();
    }

}
