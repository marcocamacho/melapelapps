package com.vonage.notify.repository
/**
 * Created by mcamacho on 9/15/15.
 */
/*
@ContextConfiguration(classes=[IntegrationTestConfig, MongoConfig])
class SubscriptionRepositoryImplTest extends Specification {

    static final String subscriptionId = "_user11235", type= "user"

    @Autowired
    MongoTemplate template

    SubscriptionRepositoryImpl subscriptionService

    def setup() {
        subscriptionService = new SubscriptionRepositoryImpl(template)
    }

    def "Save subscriptions and its consumers"() {
        given: "Initial subscription data"
        String consumer = "gunify", callback= "/notify/jdoe"

        when: "Save new subscription data"
        subscriptionService.saveSubscription(subscriptionId, type, consumer, callback)

        and: "Load subscription from storage"
        Subscription loadedSub = subscriptionService.getSubscription(subscriptionId)

        then: "Subscription fields are saved correctly"
        matchesSubscription(loadedSub)
        assert loadedSub.consumers.first().name == consumer
        assert loadedSub.consumers.first().callback == callback

        when: "Save subscription with new consumer"
        subscriptionService.saveSubscription(subscriptionId, type, "otherconsumer", "push/jdoe")

        and: "Load subscription from storage"
        loadedSub = subscriptionService.getSubscription(subscriptionId)

        then: "New consumer was added correctly"
        matchesSubscription(loadedSub)
        assert loadedSub.consumers.size() == 2
        assert loadedSub.consumers.last().name == "otherconsumer"
        assert loadedSub.consumers.last().callback == "push/jdoe"

        when: "Update subscription's consumer"
        subscriptionService.saveSubscription(subscriptionId, type, "otherconsumer", "push/notify/jdoe")

        and: "Load subscription from storage"
        loadedSub = subscriptionService.getSubscription(subscriptionId)

        then: "New consumer was saved correctly"
        matchesSubscription(loadedSub)
        assert loadedSub.consumers.size() == 2
        assert loadedSub.consumers.last().callback == "push/notify/jdoe"

        cleanup: "Delete subscription"
        subscriptionService.deleteSubscription(subscriptionId)
    }

    def "Delete consumers from subscription"() {
        given: "Initial subscription data"
        String consumer = "gunify", otherconsumer = "otherconsumer", callback= "/notify/jdoe"

        when: "Save new subscription data with two consumers"
        subscriptionService.saveSubscription(subscriptionId, type, consumer, callback)
        subscriptionService.saveSubscription(subscriptionId, type, otherconsumer, callback)

        and: "Load subscription from storage"
        Subscription loadedSub = subscriptionService.getSubscription(subscriptionId)

        then: "Subscription and consumers were saved"
        matchesSubscription(loadedSub)
        assert loadedSub.consumers.size() == 2

        when: "Remove a consumer"
        subscriptionService.removeConsumer(loadedSub, consumer)

        and: "Load subscription from storage"
        loadedSub = subscriptionService.getSubscription(subscriptionId)

        then: "Subscription has only one consumer"
        assert loadedSub.consumers.size() == 1
        assert loadedSub.consumers.first().name == otherconsumer

        when: "Remove remaining consumer"
        subscriptionService.removeConsumer(loadedSub, otherconsumer)

        and: "Load subscription from storage"
        loadedSub = subscriptionService.getSubscription(subscriptionId)

        then: "Subscription has no consumers"
        assert !loadedSub

        when: "Add a consumer back"
        subscriptionService.saveSubscription(subscriptionId, type, consumer, callback)

        and: "Load subscription from storage"
        loadedSub = subscriptionService.getSubscription(subscriptionId)

        then: "Subscription one consumer"
        assert loadedSub.consumers.size() == 1

        cleanup: "Delete subscription"
        subscriptionService.deleteSubscription(subscriptionId)
    }

    def "atest"() {

        when:
        def result = template.findAll(Subscription)

        then:
        println result
    }

    private void matchesSubscription(subscription) {
        assert subscription.subscriptionId == subscriptionId
        assert subscription.type == type
    }

}
*/
