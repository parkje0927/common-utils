package com.study.common.exception;

import lombok.Getter;

@Getter
public class FeignException extends RuntimeException {

    private final transient CommonErrorResponse commonErrorResponse;

    public FeignException(CommonErrorResponse commonErrorResponse) {
        super(commonErrorResponse.message());
        this.commonErrorResponse = commonErrorResponse;
    }
}
