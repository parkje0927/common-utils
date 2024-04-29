package com.study.common.interceptor;

import com.study.common.utils.RandomUUIDGenerator;
import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String requestId = RandomUUIDGenerator.generateRandomUUID();
        requestTemplate.header("X-Request-Id", requestId);
    }
}
