package com.gamarlos.melapelapps.repository

import com.gamarlos.melapelapps.domain.Queue
import com.gamarlos.melapelapps.domain.Queue as MelapelappsQueue
import com.gamarlos.melapelapps.domain.QueueElement

import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue

/**
 * Created by marcocamacho on 3/9/16.
 */
class QueueRepositoryStub implements QueueRepository {

    private BlockingQueue store1Clients = [
            new QueueElement(id: "85344", name: "SANDRA ELOISA", lastName: "AGUILAR ESCAMILLA"),
            new QueueElement(id: "85345", name: "JORGE", lastName: "AGUILAR ESCAMOL"),
            new QueueElement(id: "85496", name: "Kewe", lastName: "Botes"),
    ] as BlockingQueue

    private BlockingQueue store2Clients = [
            new QueueElement(id: "85565", name: "Funky", lastName: "Guy"),
            new QueueElement(id: "85581", name: "John", lastName: "Doe"),
            new QueueElement(id: "85631", name: "Frank", lastName: "Royers"),
            new QueueElement(id: "85661", name: "Pitesh", lastName: "Chingasumandranian"),
    ] as BlockingQueue

    private def storeQueues = [
            [id: "112358", queue: new Queue(clients: store1Clients)],
            [id: "112359", queue: new Queue(clients: store2Clients)]
    ]

    @Override
    MelapelappsQueue getQueue(String storeId, short limit) {
        assert limit > 0

        Map<String, Queue> queue = getStoreQueue(storeId)

        if (queue == null) {
            throw new NoSuchElementException("No queue found for " + storeId)
        }

        List clients = queue.get("queue").clients.toList()
        int qSize = clients.size()
        int fromIndex = limit > qSize ? qSize : qSize - limit
        List clientsResult = clients.subList(fromIndex, qSize)

        BlockingQueue queueResult = new ArrayBlockingQueue(100, true, clientsResult)

        return new Queue(clients: queueResult)
    }

    @Override
    void push(String storeId, QueueElement newElement) {

        Map queue = getStoreQueue(storeId)

        queue.get("queue").clients.put(newElement)
    }

    private Map<String, Queue> getStoreQueue(storeId) {
        return storeQueues.find { it.get("id") == storeId }
    }
}
