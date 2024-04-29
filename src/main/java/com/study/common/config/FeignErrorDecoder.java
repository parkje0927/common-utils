package com.study.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.common.exception.CommonException;
import com.study.common.exception.CommonErrorCode;
import com.study.common.exception.CommonErrorResponse;
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
            CommonErrorResponse commonErrorResponse = objectMapper.readValue(responseBody, CommonErrorResponse.class);
            throw new FeignException(commonErrorResponse);
        } catch (IOException e) {
            return new CommonException(CommonErrorCode.TEST_EXCEPTION);
        }
    }
}
