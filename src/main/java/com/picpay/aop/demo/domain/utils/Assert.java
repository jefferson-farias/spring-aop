package com.picpay.aop.demo.domain.utils;

public class Assert {

    public static void assertTrue(boolean evaluate, String message) {
        if (!evaluate) {
            throw new RuntimeException(message);
        }
    }
}
