package com.gamarlos.melapelapps.config

import com.mongodb.Mongo
import com.mongodb.MongoClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate

/**
 * Created by mcamacho on 9/2/15.
 */

@Configuration
class MongoConfig {

    @Value('${mongo.location}')
    String mongoLocation

    public @Bean Mongo mongo() throws Exception {
        return new MongoClient(mongoLocation);
    }

    public @Bean MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "notify");
    }

}