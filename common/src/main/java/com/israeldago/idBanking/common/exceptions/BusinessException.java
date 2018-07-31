package com.israeldago.idBanking.common.exceptions;

import com.israeldago.idBanking.common.enums.ErrorCode;

public class BusinessException extends AppException {
    public BusinessException() {
    }

    public BusinessException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public BusinessException(ErrorCode errorCode, Throwable throwable, String desc) {
        super(errorCode, throwable, desc);
    }
}
