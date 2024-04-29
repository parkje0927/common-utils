package com.study.common.exception;

import lombok.Getter;

@Getter
public class FeignException extends RuntimeException {

    private final transient ErrorResponse errorResponse;

    public FeignException(ErrorResponse errorResponse) {
        super(errorResponse.message());
        this.errorResponse = errorResponse;
    }
}
