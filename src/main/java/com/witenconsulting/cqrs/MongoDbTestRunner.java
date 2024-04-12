package com.witenconsulting.cqrs;

import com.witenconsulting.cqrs.repository.PersonReadModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MongoDbTestRunner implements CommandLineRunner {

    private final PersonReadModelRepository repository;

    @Autowired
    public MongoDbTestRunner(PersonReadModelRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MongoDB Contents:");
        repository.findAll().forEach(item -> {
            System.out.println(item.toString());
        });
    }
}