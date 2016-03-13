package com.gamarlos.melapelapps.repository

import com.gamarlos.melapelapps.domain.MappsQueue
import com.gamarlos.melapelapps.domain.QueueElement
import spock.lang.Specification

import java.util.concurrent.ArrayBlockingQueue

/**
 * Created by mcamacho on 3/12/16.
 */
class QueueRepositoryStubTest extends Specification {

    QueueRepositoryStub repository = new QueueRepositoryStub()

    def "setup"() {
        repository.storeQueues = [
                [id: "112358", queue: new MappsQueue(clients: new ArrayBlockingQueue(10))]
        ]
    }

    def "GetQueue"() {
        given:
        String storeId = "112358"
        short limit = 10
        repository.storeQueues.find { it.id == storeId }.queue.clients.add(new QueueElement(id: "abc", name: "NameA", lastName: "LastName"))
        repository.storeQueues.find { it.id == storeId }.queue.clients.add(new QueueElement(id: "dfg", name: "NameD", lastName: "LastName"))

        when:
        MappsQueue queue = repository.getQueue(storeId, limit)

        then:
        QueueElement firstElement = queue.clients.first()
        QueueElement lastElement = queue.clients.last()

        assert firstElement.id == "abc"
        assert firstElement.name == "NameA"
        assert firstElement.lastName == "LastName"

        assert lastElement.id == "dfg"
        assert lastElement.name == "NameD"
        assert lastElement.lastName == "LastName"
    }

    def "GetQueue: No elements in queue"() {
        given:
        String storeId = "112358"
        short limit = 10

        expect:
        repository.getQueue(storeId, limit).clients.size() == 0
    }

    def "GetQueue: No store"() {
        given:
        String storeId = "112359"
        short limit = 10

        when:
        repository.getQueue(storeId, limit)

        then:
        thrown NoSuchElementException
    }

    def "Push"() {
        given:
        String storeId = "112358"

        when:
        repository.push(storeId, new QueueElement(id: "abc", name: "NameA", lastName: "LastName"))
        repository.push(storeId, new QueueElement(id: "dfg", name: "NameD", lastName: "LastName"))

        then:
        QueueElement firstElement = repository.storeQueues.find { it.id == storeId }.queue.clients.take()
        QueueElement lastElement = repository.storeQueues.find { it.id == storeId }.queue.clients.take()

        assert firstElement.id == "abc"
        assert firstElement.name == "NameA"
        assert firstElement.lastName == "LastName"

        assert lastElement.id == "dfg"
        assert lastElement.name == "NameD"
        assert lastElement.lastName == "LastName"
    }

    def "Remove"() {
        given:
        String storeId = "112358"
        String clientId = "abc"
        repository.storeQueues.find { it.id == storeId }.queue.clients.add(
                new QueueElement(id: "abc", name: "NameA", lastName: "LastName"))

        when:
        repository.remove(storeId, clientId)

        then:
        assert repository.storeQueues.find { it.id == storeId }.queue.clients.size() == 0
    }

    def "Remove: empty queue"() {
        given:
        String storeId = "112358"
        String clientId = "abc"

        when:
        repository.remove(storeId, clientId)

        then:
        assert true
    }
}
