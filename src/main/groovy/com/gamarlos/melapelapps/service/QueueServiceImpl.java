package com.gamarlos.melapelapps.service;

import com.gamarlos.melapelapps.domain.MappsQueue;
import com.gamarlos.melapelapps.domain.QueueElement;
import com.gamarlos.melapelapps.repository.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/**
 * Created by marcocamacho on 3/9/16.
 */
public class QueueServiceImpl implements QueueService {

    @Autowired
    QueueRepository queueRepository;

    @Override
    public MappsQueue getQueue(String storeId, short size, short page) {
        return queueRepository.getQueue(storeId, size, page);
    }

    @Override
    public void pushElement(String storeId, QueueElement newElement) {
        newElement.setDateAdded(LocalDateTime.now());
        queueRepository.push(storeId, newElement);
    }

    @Override
    public void remove(String storeId, String clientId) {
        queueRepository.remove(storeId, clientId);
    }
}
