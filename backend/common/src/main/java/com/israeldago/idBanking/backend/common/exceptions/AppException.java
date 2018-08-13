package com.israeldago.idBanking.backend.common.exceptions;

import com.israeldago.idBanking.backend.common.enums.ErrorCode;

import java.util.Objects;

abstract class AppException extends RuntimeException {

    private ErrorCode errorCode;

    AppException(ErrorCode errorCode) {this(errorCode,null,"");}

    AppException(ErrorCode errorCode,String desc) {
        this(errorCode,null,desc);
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
