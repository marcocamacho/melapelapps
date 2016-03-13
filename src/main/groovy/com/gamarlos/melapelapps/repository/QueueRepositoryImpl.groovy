package com.gamarlos.melapelapps.repository

import com.gamarlos.melapelapps.domain.MappsQueue
import com.gamarlos.melapelapps.domain.QueueElement

/**
 * Created by marcocamacho on 3/9/16.
 */
class QueueRepositoryImpl implements QueueRepository {

    @Override
    MappsQueue getQueue(String storeId, short size) {
        return null
    }

    @Override
    void push(String storeId, QueueElement newElement) {

    }

    @Override
    void remove(String storeId, String clientId) {

    }
}
