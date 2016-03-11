package com.gamarlos.melapelapps.service;

import java.util.Map;

/**
 * Created by mcamacho on 9/16/15.
 */
public interface SubscriptionManager {

    Map<String, String> getConsumerSubscription(String subscriptionId, String consumer);

    void removeConsumerSubscription(String subscriptionId, String consumer);

    void saveSubscription(String subscriptionId, String type, String consumer, String callback);
}
