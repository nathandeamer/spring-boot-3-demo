package com.nathandeamer.demo.shared.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class ServerException extends RuntimeException {

    private final HttpStatusCode httpStatusCode;

    public ServerException(HttpStatusCode httpStatusCode, String errorMessage) {
        super(errorMessage);
        this.httpStatusCode = httpStatusCode;
    }

}
