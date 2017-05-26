package com.gamarlos.melapelapps

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer

/**
 * Created by mcamacho on 9/26/15.
 *
 * Loads the properties from application-integration.properties file.
 * ConfigFileApplicationContextInitializer is meant to solve that, but it only
 * works for spring boot apps. The idea of an integration test is not to do a system
 * or user acceptance kind of test (if so, the entire app would be required to be up
 * and running), but rather testing the edges of our app with the system under integration.
 * Currently there are two limitations in spring which prevent the
 * integration test be isolated from spring boot apps:
 * 1. ConfigFileApplicationContextInitializer does not  work outside a boot app
 * 2. @PropertySource does not support yaml files yet
 *
 * A nice conversation with Steven Landers helped me on clarifying the advantages of integration
 * testing (not system like kind of integration testing):
 * * Clarifies contract, scenarios and usage
 * * Don't have to deploy the entire app to get feedback
 * * It does cover some testing: while testing crud might be not that meaningful,
 *   there are some other scenarios where it add more value. In mongo, for instance,
 *   when doing filters, projections, aggregations, etc.; in a relational DB, what about
 *   queries, needed fields, filters, etc.
 * * The test includes the configuration (setup, config vars, etc). While configuration in an integration
 *   environment is not the same as in prod (nothing will ever be exactly like in production
 *   anyway!), it does get you closer to it.
 * * Makes you (developer) think about the deployment model in terms of how servers will be allocated
 * * Might give you feedback and confidence and some certainty if changes happen on the
 *   external system or if the version is upgraded.
 */
@Configuration
@PropertySource("classpath:application-integration.properties")
class IntegrationTestConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer()
    }
}
