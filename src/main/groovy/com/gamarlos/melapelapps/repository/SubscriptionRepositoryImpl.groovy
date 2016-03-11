package com.gamarlos.melapelapps.repository
/**
 * Created by mcamacho on 9/2/15.
 */
class SubscriptionRepositoryImpl implements SubscriptionRepository {
/*
    MongoTemplate mongoTemplate

    SubscriptionRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate
    }

    @Override
    Subscription getSubscription(String subscriptionId) {
        return mongoTemplate.findById(subscriptionId, Subscription)
    }

    @Override
    void saveSubscription(String subscriptionId, String type, String consumer, String callback) {
        Subscription subscription = getSubscription(subscriptionId)

        if (subscription == null) {
            subscription = new Subscription(subscriptionId, type, [new ServiceConsumer(consumer, callback)])
            mongoTemplate.save(subscription)
            return;
        }

        ServiceConsumer serviceConsumer = subscription.consumers?.find{ it.name == consumer }

        if (serviceConsumer == null) {
            //new consumer to existing subscription
            serviceConsumer = new ServiceConsumer(consumer, callback)
            if (subscription.consumers == null) {
                subscription.consumers = []
            }
            subscription.consumers.add(serviceConsumer)
        } else {
            serviceConsumer.callback = callback
        }

        mongoTemplate.save(subscription)
    }

    @Override
    void removeConsumer(Subscription subscription, String consumer) {
        ServiceConsumer serviceConsumer = subscription.consumers?.find{ it.name == consumer }

        if (serviceConsumer != null) {
            subscription.consumers.removeAll{ it.name == consumer }
            //if no more consumers, delete the document
            if (subscription.consumers.size() == 0) {
                mongoTemplate.remove(subscription)
            } else {
                mongoTemplate.save(subscription)
            }
        }
    }

    @Override
    void deleteSubscription(String subscriptionId) {
        mongoTemplate.remove(query(where("_id").is(subscriptionId)), Subscription)
    }
*/
}
