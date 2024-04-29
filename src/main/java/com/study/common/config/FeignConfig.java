package com.study.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.common.interceptor.FeignInterceptor;
import feign.Feign;
import feign.Logger;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
public class FeignConfig {

    private final ObjectMapper objectMapper;

    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignErrorDecoder(objectMapper);
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Feign.Builder feignBuilder() {
        return Feign.builder().requestInterceptor(new FeignInterceptor());
    }
}
