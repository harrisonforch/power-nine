package com.example.powernine.login;

import com.example.powernine.deck.DeckRepository;
import com.example.powernine.user.User;
import com.example.powernine.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
class LoadAdminDatabase {

    @Autowired
    private PasswordEncoder encoder;

    private static final Logger log = LoggerFactory.getLogger(LoadAdminDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, DeckRepository deckRepository) {

        userRepository.deleteAll();
        deckRepository.deleteAll();

        // admin:welcome1
        return args -> {
            log.info("Preloading " + userRepository.save(new User("admin",
                    "$2a$10$AjHGc4x3Nez/p4ZpvFDWeO6FGxee/cVqj5KHHnHfuLnIOzC5ag4fm",
                    "ROLE_ADMIN")));
            User user = new User("user", "password1", "ROLE_USER");
            user.setPassword(encoder.encode(user.getPassword()));
            log.info("Preloading " + userRepository.save(user));
        };
    }
}
