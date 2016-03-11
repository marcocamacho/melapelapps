package com.gamarlos.melapelapps.domain

/**
 * Created by mcamacho on 9/15/15.
 */
class ServiceConsumer {
    String name
    String callback

    ServiceConsumer() {

    }
    ServiceConsumer(String name, String callback) {
        this.name = name
        this.callback = callback
    }

}
