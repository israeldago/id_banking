package com.israeldago.idBanking.common.exceptions;

import com.israeldago.idBanking.common.enums.ErrorCode;

import java.util.Objects;

abstract class AppException extends RuntimeException {

    private ErrorCode errorCode;

    AppException() {}

    AppException(ErrorCode errorCode,Throwable throwable) {
        this(errorCode,throwable,"");
    }

    AppException(ErrorCode errorCode, Throwable throwable, String desc) {
        super(desc, throwable);
         this.errorCode = Objects.requireNonNull(errorCode);
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = Objects.requireNonNull(errorCode);
    }
}
