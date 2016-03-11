package com.gamarlos.melapelapps.domain

import groovy.transform.ToString

/**
 * Created by mcamacho on 9/10/15.
 */
@ToString
class EventMessage {

    //private Logger log = LoggerFactory.getLogger(EventMessage)

    String event;
    String consumer;
    Boolean internal;
    String direction;
    String appserverHost;
    String accountNumber;
    String callId;
    Date startTime;
    Date eventTimestamp;
    Boolean isRecorded;
    Boolean isClickToCall;
    Long durationMs;
    String customTag;
    String dialedNumber;
    LocalParty local;
    RemoteParty remote;

    public String username() {
        return local.username
    }

    public String event() {
        return event
    }
/*
    public boolean isExpired(Long expirationMs){
        long tooOldTime = new Date().getTime()-expirationMs
        long eventTime = eventTimestamp.getTime()

        boolean tooOld = eventTime < tooOldTime
        if(tooOld){
            log.debug("Message is expired: tooOldTime=${tooOldTime}, eventTime=${eventTime}, expirationMs=${expirationMs}")
        }
        return tooOld
    }*/
}
