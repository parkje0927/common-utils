package com.study.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum CommonErrorCode {

    TEST_EXCEPTION("test exception", HttpStatus.BAD_REQUEST);

    private final String message;
    private final HttpStatus httpStatus;

    CommonErrorCode(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
