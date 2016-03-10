package com.gamarlos.melapelapps.repository;

import com.gamarlos.melapelapps.domain.Queue;
import com.gamarlos.melapelapps.domain.QueueElement;

import java.util.List;
import java.util.Map;

/**
 * Created by marcocamacho on 3/9/16.
 */
public interface QueueRepository {

    Queue getQueue(String storeId);

    void push(String storeId, QueueElement newElement);
}
