package com.gamarlos.melapelapps.repository;

import com.gamarlos.melapelapps.domain.MappsQueue;
import com.gamarlos.melapelapps.domain.QueueElement;

/**
 * Created by marcocamacho on 3/9/16.
 */
public interface QueueRepository {

    MappsQueue getQueue(String storeId, short size);

    void push(String storeId, QueueElement newElement);

    void remove(String storeId, String clientId);
}
