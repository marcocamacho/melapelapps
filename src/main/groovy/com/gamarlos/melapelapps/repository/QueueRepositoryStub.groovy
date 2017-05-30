package com.gamarlos.melapelapps.repository

import com.gamarlos.melapelapps.domain.MappsQueue
import com.gamarlos.melapelapps.domain.QueueElement

import java.time.LocalDateTime
import java.time.temporal.ChronoField
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue

import static java.time.LocalDateTime.now
import static java.time.temporal.ChronoField.MINUTE_OF_HOUR

/**
 * Created by marcocamacho on 3/9/16.
 */
class QueueRepositoryStub implements QueueRepository {

    private List store1Clients = [
            new QueueElement(id: "85344", name: "SANDRA ELOISA", lastName: "AGUILAR ESCAMILLA", dateAdded: now()),
            new QueueElement(id: "85345", name: "JORGE", lastName: "AGUILAR ESCAMOL", dateAdded: now().minus(1, MINUTE_OF_HOUR.baseUnit)),
            new QueueElement(id: "85496", name: "Kewe", lastName: "Botes", dateAdded: now().minus(3, MINUTE_OF_HOUR.baseUnit)),
    ]

    private List store2Clients = [
            new QueueElement(id: "85565", name: "Funky",    lastName: "Guy",            dateAdded: now()),
            new QueueElement(id: "85581", name: "John",     lastName: "Doe",            dateAdded: now().minus(1, MINUTE_OF_HOUR.baseUnit)),
            new QueueElement(id: "85631", name: "Frank",    lastName: "Royers",         dateAdded: now().minus(3, MINUTE_OF_HOUR.baseUnit)),
            new QueueElement(id: "85661", name: "Pitesh",   lastName: "Chingasumandranian", dateAdded: now().minus(5, MINUTE_OF_HOUR.baseUnit)),
    ]

    protected def storeQueues = [
            [id: "112358", queue: new MappsQueue(clients: new ArrayBlockingQueue<QueueElement>(20, true, store1Clients))],
            [id: "112359", queue: new MappsQueue(clients: new ArrayBlockingQueue<QueueElement>(20, true, store2Clients))]
    ]

    @Override
    MappsQueue getQueue(String storeId, short limit, short page) {
        assert limit > 0
        assert page > 0

        Map<String, MappsQueue> queue = getStoreQueue(storeId)

        if (queue == null) {
            throw new NoSuchElementException("No queue found for " + storeId)
        }

        List clients = queue.get("queue").clients.toList()
        int qSize = clients.size()

        if (qSize < (limit * page) - limit)
            throw new IllegalArgumentException("page size cannot is out of range for total " + qSize)

        int fromIndex = limit > qSize ? 0 : qSize - limit
        int fromIndexPaged = fromIndex - (limit * (page - 1))
        int toIndexPaged = qSize - (limit * (page - 1))

        List clientsResult = clients.subList(fromIndexPaged, toIndexPaged)

        BlockingQueue queueResult = new ArrayBlockingQueue(100, true, clientsResult)

        return new MappsQueue(clients: queueResult)
    }

    @Override
    void push(String storeId, QueueElement newElement) {

        Map queue = getStoreQueue(storeId)

        queue.get("queue").clients.offer(newElement)
    }

    @Override
    void remove(String storeId, String clientId) {
        Map<String, MappsQueue> queue = getStoreQueue(storeId)

        if (queue == null) {
            throw new NoSuchElementException("No queue found for " + storeId)
        }

        queue.get("queue").clients.remove(new QueueElement(id: clientId))
    }

    private Map<String, MappsQueue> getStoreQueue(storeId) {
        return storeQueues.find { it.get("id") == storeId }
    }
}
