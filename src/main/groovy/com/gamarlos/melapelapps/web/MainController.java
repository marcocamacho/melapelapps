package com.gamarlos.melapelapps.web;

import com.gamarlos.melapelapps.domain.MappsQueue;
import com.gamarlos.melapelapps.domain.QueueElement;
import com.gamarlos.melapelapps.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by marcocamacho on 3/9/16.
 */
@RestController
public class MainController {

    @Autowired
    private QueueService queueService;

    @RequestMapping(value = "/queue/{storeId}", method = RequestMethod.GET)
    public MappsQueue getQueue(@PathVariable String storeId, @RequestParam short size) {
        return queueService.getQueue(storeId, size);
    }

    @RequestMapping(value = "/queue/{storeId}", method = RequestMethod.POST)
    public void enqueue(@PathVariable String storeId, @RequestBody QueueElement queueElement) {
        queueService.pushElement(storeId, queueElement);
    }

    @RequestMapping(value = "/queue/{storeId}/{elementId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String storeId, @PathVariable String elementId) {
        queueService.remove(storeId, elementId);
    }

    public void setQueueService(QueueService queueService) {
        this.queueService = queueService;
    }

}
