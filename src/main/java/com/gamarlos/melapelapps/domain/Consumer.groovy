package com.gamarlos.melapelapps.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by mcamcho on 9/17/15.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Document
class Consumer {
    @Id
    String id
    String url
    String provider
}
