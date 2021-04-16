package com.example.powernine.config;


import com.example.powernine.repositories.CardRepository;
import com.example.powernine.repositories.DeckRpository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = CardRepository .class)
@Configuration
public class MongoDBConfig
{
}
