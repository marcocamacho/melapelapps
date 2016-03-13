package com.gamarlos.melapelapps.web

import com.gamarlos.melapelapps.domain.QueueElement
import com.gamarlos.melapelapps.service.QueueService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by marcocamacho on 3/9/16.
 */
@RestController
public class MainController {

    @Autowired QueueService queueService

    @RequestMapping(value = "/heartbeat", method = RequestMethod.GET)
    def heartbeat() {
        return "melapelapps";
    }

    @RequestMapping(value = "/queue/{storeId}", method = RequestMethod.GET)
    def getQueue(@PathVariable String storeId, @RequestParam short size) {
        return queueService.getQueue(storeId, size)
    }

    @RequestMapping(value = "/queue/{storeId}", method = RequestMethod.POST)
    void enqueue(@PathVariable String storeId, @RequestBody QueueElement queueElement) {
        queueService.pushElement(storeId, queueElement)
    }

    @RequestMapping(value = "/queue/{storeId}/{elementId}", method = RequestMethod.DELETE)
    void blah(@PathVariable String storeId, @PathVariable String elementId) {
        queueService.remove(storeId, elementId)
    }
}