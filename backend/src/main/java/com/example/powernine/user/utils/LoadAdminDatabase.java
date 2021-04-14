package com.example.powernine.user.utils;

import com.example.powernine.user.User;
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
        // admin:password1
        return args -> {
            log.info("Preloading " + repository.save(new User("admin", "$2a$10$AjHGc4x3Nez/p4ZpvFDWeO6FGxee/cVqj5KHHnHfuLnIOzC5ag4fm")));
        };
    }
}
