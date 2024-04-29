package com.study.common.exception;

import org.springframework.http.HttpStatus;

public record CommonErrorResponse(
        String message,
        HttpStatus httpStatus
) {

    public static CommonErrorResponse fromErrorCode(CommonErrorCode commonErrorCode) {
        return new CommonErrorResponse(commonErrorCode.getMessage(), commonErrorCode.getHttpStatus());
    }
}

