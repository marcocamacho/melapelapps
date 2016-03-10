package com.gamarlos.melapelapps.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
//import com.vonage.notify.exception.ConsumerSubscriptionNotFoundException
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@JsonIgnoreProperties(ignoreUnknown = true)
@Document
class Subscription {
    public static final String CONSUMER_GUNIFY = "gunify"
    public static final String TYPE_USER = "user"

    @Id
    String subscriptionId
    String type
    List<ServiceConsumer> consumers

    Subscription(String subscriptionId, String type, List<ServiceConsumer> consumers) {
        this.subscriptionId = subscriptionId
        this.type = type
        this.consumers = consumers
    }

    Map<String, String> getConsumerSubscription(String consumerName) {
        ServiceConsumer consumer = consumers?.find{ it.name == consumerName }

        if (consumer == null) {
           // throw new ConsumerSubscriptionNotFoundException(consumerName)
        }

        return [
                "username" : subscriptionId,
                "callback_url" : consumer.callback
        ]
    }
}