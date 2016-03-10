package com.gamarlos.melapelapps.web

import com.gamarlos.melapelapps.domain.QueueElement
import com.gamarlos.melapelapps.service.QueueService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by marcocamacho on 3/9/16.
 */
@RestController
public class MainController {

    @Autowired QueueService queueService

    @RequestMapping(value = "/heartbeat", method = RequestMethod.GET)
    def hello() {
        return "melapelapps";
    }

    @RequestMapping(value = "/v0/queue/{storeId}", method = RequestMethod.GET)
    def getQueue(@PathVariable String storeId) {
        return queueService.getQueue(storeId)
    }

    @RequestMapping(value = "/v0/queue/{storeId}", method = RequestMethod.POST)
    void enqueue(@PathVariable String storeId, @RequestBody QueueElement queueElement) {
        queueService.pushElement(storeId, queueElement)
    }

    @RequestMapping(value = "/v0/clients", method = RequestMethod.GET)
    def getClients() {
        def map = [
                [id: "85344", name: "SANDRA ELOISA", lastName: "AGUILAR ESCAMILLA"],
                [id: "85345", name: "JORGE", lastName: "AGUILAR ESCAMOL"],
        ]

        return [records: map]

    }

    @RequestMapping(value = "/v0/clients", method = RequestMethod.PUT)
    def saveClient(@PathVariable String id) {
        return [id: "abcdxyz", name: "Elmer", lastname: "Homero"]
    }
}