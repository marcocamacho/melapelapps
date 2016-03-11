package com.gamarlos.melapelapps.service;

import com.gamarlos.melapelapps.domain.Queue;
import com.gamarlos.melapelapps.domain.QueueElement;
import com.gamarlos.melapelapps.repository.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by marcocamacho on 3/9/16.
 */
public class QueueServiceImpl implements QueueService {

    @Autowired
    QueueRepository queueRepository;

    @Override
    public Queue getQueue(String storeId, short size) {
        return queueRepository.getQueue(storeId, size);
    }

    @Override
    public void pushElement(String storeId, QueueElement newElement) {
        queueRepository.push(storeId, newElement);
    }
}
