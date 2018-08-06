package com.israeldago.idBanking.common.exceptions;

import com.israeldago.idBanking.common.enums.ErrorCode;

public class PresentationException extends AppException {
    public PresentationException(ErrorCode errorCode) {
        super(errorCode);
    }

    public PresentationException(ErrorCode errorCode, String desc) {
        super(errorCode, desc);
    }

    public PresentationException(ErrorCode errorCode, Throwable throwable, String desc) {
        super(errorCode, throwable, desc);
    }
}
