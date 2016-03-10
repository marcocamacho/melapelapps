package com.gamarlos.melapelapps

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard

@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableCaching
class MelapelasApplication {

    static void main(String[] args) {
        SpringApplication.run(MelapelasApplication, args)
    }
}
