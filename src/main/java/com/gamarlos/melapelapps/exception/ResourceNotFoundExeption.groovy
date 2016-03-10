package com.gamarlos.melapelapps.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Created by mcamacho on 9/2/15.
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND)
class ResourceNotFoundExeption extends RuntimeException {

    public ResourceNotFoundExeption(String message){
        super(message)
    }

}
