package com.study.common.utils;

import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class RandomUUIDGenerator {

    public static String generateRandomUUID() {
        return UUID.randomUUID().toString();
    }
}
