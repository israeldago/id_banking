package com.israeldago.idBanking.common.exceptions;

import com.israeldago.idBanking.common.enums.ErrorCode;

public class PresentationException extends AppException {
    public PresentationException() {
    }

    public PresentationException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public PresentationException(ErrorCode errorCode, Throwable throwable, String desc) {
        super(errorCode, throwable, desc);
    }
}
