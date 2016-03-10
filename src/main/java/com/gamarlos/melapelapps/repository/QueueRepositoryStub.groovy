package com.gamarlos.melapelapps.repository

import com.gamarlos.melapelapps.domain.Queue
import com.gamarlos.melapelapps.domain.Queue as MelapelappsQueue
import com.gamarlos.melapelapps.domain.QueueElement

/**
 * Created by marcocamacho on 3/9/16.
 */
class QueueRepositoryStub implements QueueRepository {

    private List clients = [
            new QueueElement(id: "85344", name: "SANDRA ELOISA", lastName: "AGUILAR ESCAMILLA"),
            new QueueElement(id: "85345", name: "JORGE", lastName: "AGUILAR ESCAMOL"),
            new QueueElement(id: "85496", name: "Kewe", lastName: "Botes"),
    ]

    private def melapelappsStoreQueues = [
            [id: "112358", queue: new Queue(clients: clients)]
    ]

    @Override
    MelapelappsQueue getQueue(String storeId) {
        Map queue = getStoreQueue(storeId)

        if (queue == null) {
            throw new NoSuchElementException("No queue found for " + storeId)
        }

        return queue.get("queue")
    }

    @Override
    void push(String storeId, QueueElement newElement) {
        Map queue = getStoreQueue(storeId)

        queue.get("queue").clients.push(newElement)
    }

    private Map getStoreQueue(storeId) {
        return melapelappsStoreQueues.find { it.get("id") == storeId }
    }
}
