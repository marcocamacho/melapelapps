package com.gamarlos.melapelapps.repository

import com.gamarlos.melapelapps.domain.QueueElement

/**
 * Created by marcocamacho on 3/9/16.
 */
class QueueRepositoryImpl implements QueueRepository {

    @Override
    com.gamarlos.melapelapps.domain.Queue getQueue(String storeId, short size) {
        return null
    }

    @Override
    void push(String storeId, QueueElement newElement) {

    }
}
