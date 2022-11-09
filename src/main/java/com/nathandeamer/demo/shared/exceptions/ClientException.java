package com.nathandeamer.demo.shared.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class ClientException extends RuntimeException {

    private final HttpStatusCode httpStatusCode;

    public ClientException(HttpStatusCode httpStatusCode, String errorMessage) {
        super(errorMessage);
        this.httpStatusCode = httpStatusCode;
    }
}
