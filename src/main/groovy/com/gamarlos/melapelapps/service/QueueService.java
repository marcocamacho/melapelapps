package com.gamarlos.melapelapps.service;

import com.gamarlos.melapelapps.domain.MappsQueue;
import com.gamarlos.melapelapps.domain.QueueElement;

/**
 * Created by marcocamacho on 3/9/16.
 */
public interface QueueService {

    MappsQueue getQueue(String storeId, short size, short page);

    void pushElement(String storeId, QueueElement newElement);

    void remove(String storeId, String clientId);
}
