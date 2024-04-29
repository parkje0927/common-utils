package com.study.common.wrapper;

import jakarta.annotation.Nullable;

public record ResponseResult<T>(
        @Nullable T result
) {

    public static <T> ResponseResult<T> from(T result) {
        return new ResponseResult<>(result);
    }
}
