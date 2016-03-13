package com.gamarlos.melapelapps.domain

import org.springframework.format.annotation.DateTimeFormat

import java.time.LocalDateTime

/**
 * Created by marcocamacho on 3/10/16.
 */
class MappsQueue {
    Collection<QueueElement> clients
}

class QueueElement {
    String id
    String name
    String lastName
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime dateAdded

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof QueueElement)) return false

        QueueElement that = (QueueElement) o

        if (id != that.id) return false

        return true
    }

    int hashCode() {
        return id.hashCode()
    }
}
