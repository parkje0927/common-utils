package com.study.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class JacksonConfig {

    private static ObjectMapper objectMapper;

    @Primary
    @Bean
    public ObjectMapper objectMapper() {
        return objectMapper;
    }

    @Bean
    public ObjectMapper customObjectMapper() {
        return generateCustomObjectMapper();
    }

    private static ObjectMapper generateCustomObjectMapper() {
        if (objectMapper == null) {
            objectMapper = JsonMapper.builder()
                    .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                    .build();
        }
        return objectMapper;
    }
}
