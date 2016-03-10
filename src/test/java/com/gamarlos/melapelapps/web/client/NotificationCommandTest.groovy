package com.gamarlos.melapelapps.web.client

import spock.lang.Specification

/**
 * Created by mcamcho on 9/23/15.
 */
class NotificationCommandTest extends Specification {

    def "ExtractUserFromRequest"() {
        expect:
        "slanders" == NotificationCommand.extractUserFromRequest("/test?user=slanders")
    }

    def "ExtractUserFromRequestWithLatterParams"() {
        expect:
        "slanders" == NotificationCommand.extractUserFromRequest("/test?user=slanders&var=val")
    }

    def "ExtractUserFromRequestWithNull"() {
        expect:
        null == NotificationCommand.extractUserFromRequest("/test")
    }

    def "ExtractPathFromCallbackUri"(){
        expect:
        "/test" == NotificationCommand.extractPathFromCallbackUri("/test?user=slanders")
    }
}
