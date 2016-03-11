package com.gamarlos.melapelapps.service;

import com.gamarlos.melapelapps.domain.Queue;
import com.gamarlos.melapelapps.domain.QueueElement;

import java.util.List;
import java.util.Map;

/**
 * Created by marcocamacho on 3/9/16.
 */
public interface QueueService {

    Queue getQueue(String storeId, short size);

    void pushElement(String storeId, QueueElement newElement);
}
