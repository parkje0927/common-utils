package com.study.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.common.exception.CommonException;
import com.study.common.exception.ErrorCode;
import com.study.common.exception.ErrorResponse;
import com.study.common.exception.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.io.InputStream;

public class FeignErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper;

    public FeignErrorDecoder(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Exception decode(String str, Response response) {
        try (InputStream responseBody = response.body().asInputStream()) {
            ErrorResponse errorResponse = objectMapper.readValue(responseBody, ErrorResponse.class);
            throw new FeignException(errorResponse);
        } catch (IOException e) {
            return new CommonException(ErrorCode.TEST_EXCEPTION);
        }
    }
}
