package com.israeldago.idBanking.common.enums;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

public enum ErrorCode {
    TECHNICAL(INTERNAL_SERVER_ERROR),
    USER_NOT_FOUND(NOT_FOUND);

    private final HttpStatus status;

    ErrorCode(HttpStatus status) {
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
