package com.study.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FeignConfig {

    private final ObjectMapper objectMapper;
}
