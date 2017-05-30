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
        short limit = 10, page = 1
        repository.storeQueues.find { it.id == storeId }.queue.clients.with {
            add(new QueueElement(id: "abc", name: "NameA", lastName: "LastName"))
            add(new QueueElement(id: "dfg", name: "NameD", lastName: "LastName"))
        }

        when:
        MappsQueue queue = repository.getQueue(storeId, limit, page)

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
        short limit = 10, page = 1

        expect:
        repository.getQueue(storeId, limit, page).clients.size() == 0
    }

    def "GetQueue: get page two"() {
        given:
        String storeId = "112358"
        short limit = 1, page = 2

        repository.storeQueues.find { it.id == storeId }.queue.clients.with {
            add(new QueueElement(id: "abc", name: "NameA", lastName: "LastNameA"))
            add(new QueueElement(id: "dfg", name: "NameD", lastName: "LastNameD"))
            add(new QueueElement(id: "hij", name: "NameH", lastName: "LastNameH"))
        }

        when:
        MappsQueue queue = repository.getQueue(storeId, limit, page)

        then:
        assert queue.clients.size() == 1
        QueueElement firstElement = queue.clients.first()

        assert firstElement.id == "dfg"
        assert firstElement.name == "NameD"
        assert firstElement.lastName == "LastNameD"
    }

    def "GetQueue: get page out of range"() {
        given:
        String storeId = "112358"
        short limit = 1, page = 8

        repository.storeQueues.find { it.id == storeId }.queue.clients.with {
            add(new QueueElement(id: "hij", name: "NameH", lastName: "LastNameH"))
        }

        when:
        repository.getQueue(storeId, limit, page)

        then:
        thrown(IllegalArgumentException)
    }

    def "GetQueue: No store"() {
        given:
        String storeId = "112359"
        short limit = 10

        when:
        repository.getQueue(storeId, limit, (short) 0)

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
