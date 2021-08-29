package com.gitswabber.spring.reactive.service;

import com.gitswabber.spring.reactive.repository.BlockingItemRepository;
import com.gitswabber.spring.reactive.repository.Item;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

@Component
public class RepositoryDatabaseLoader {

    // CommandLineRunner is component which has only run() method.
    // This functional interface is executed after all component are activated.
//    @Bean
    CommandLineRunner initialize(BlockingItemRepository repository) {
        // The parameter of this method is blocking repository and it would be trouble since this project is intended to use non-blocking code.
        // If blocking code is mixed with non-blocking code the throughput of web traffic would not be increased effectively.
        // So it is important to restrict making blocking code. Don't use blocking repository in this case.
        // Then How to load data? Use ReactiveMongoTemplate. (MongoTemplate is for blocking version.)
        return args -> {
            repository.save(new Item("Alf alarm clock", 19.99));
            repository.save(new Item("Smurt TV tray", 24.99));
        };
    }

    // To load data with blocking type without using blocking repository it needs to use MongoOperations.
    // MongoOperations is type of JdbcOperations interface and it decouples application and db.
    @Bean
    CommandLineRunner initialize(MongoOperations mongo) {
        return args -> {
            mongo.save(new Item("Alf alarm clock", 19.99));
            mongo.save(new Item("Smurt TV tray", 24.99));
        };
    }
}
