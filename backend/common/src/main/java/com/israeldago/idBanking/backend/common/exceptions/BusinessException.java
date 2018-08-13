package com.israeldago.idBanking.backend.common.exceptions;

import com.israeldago.idBanking.backend.common.enums.ErrorCode;

public class BusinessException extends AppException {
    public BusinessException(ErrorCode errorCode) {
        super(errorCode);
    }

    public BusinessException(ErrorCode errorCode, String desc) {
        super(errorCode, desc);
    }

    public BusinessException(ErrorCode errorCode, Throwable throwable, String desc) {
        super(errorCode, throwable, desc);
    }
}
