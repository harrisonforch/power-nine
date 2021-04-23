package com.example.powernine.config;


import com.example.powernine.document.CardRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = CardRepository .class)
@Configuration
public class MongoDBConfig
{
}
