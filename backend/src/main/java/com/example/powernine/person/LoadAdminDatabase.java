package com.example.powernine.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadAdminDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadAdminDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {

        repository.deleteAll();

        return args -> {
            log.info("Preloading " + repository.save(new User("admin", "admin")));
        };
    }
}
