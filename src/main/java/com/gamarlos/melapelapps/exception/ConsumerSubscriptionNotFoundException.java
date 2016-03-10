package com.gamarlos.melapelapps.exception;

/**
 * Created by mcamacho on 9/16/15.
 */
public class ConsumerSubscriptionNotFoundException extends RuntimeException {
    static final String PARTIAL_MESSAGE = " not found in subscription.";

    public ConsumerSubscriptionNotFoundException(String object) {
        super(object + PARTIAL_MESSAGE);
    }
}
