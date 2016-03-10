package com.gamarlos.melapelapps.config;

import com.gamarlos.melapelapps.service.QueueService;
import com.gamarlos.melapelapps.repository.QueueRepository;
import com.gamarlos.melapelapps.repository.QueueRepositoryStub;
import com.gamarlos.melapelapps.service.QueueServiceImpl;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mcamacho on 9/14/15.
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public QueueService queueService() {
        return new QueueServiceImpl();
    }

    @Bean
    public QueueRepository queueRepository() {
        return new QueueRepositoryStub();
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("consumers", "consumerClients");
    }

}
