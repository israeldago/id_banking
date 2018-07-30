package com.israeldago.idBanking.common.exceptions;

abstract class AppException extends RuntimeException {

     AppException() {}

     AppException(String desc) {
        super(desc);
    }

     AppException(String desc, Throwable throwable) {
        super(desc, throwable);
    }

     AppException(Throwable throwable) {
        super(throwable);
    }
}
