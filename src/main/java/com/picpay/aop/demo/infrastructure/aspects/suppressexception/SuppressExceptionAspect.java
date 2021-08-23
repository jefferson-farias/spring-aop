package com.picpay.aop.demo.infrastructure.aspects.suppressexception;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class SuppressExceptionAspect {

    private final ApplicationContext applicationContext; // como é um bean do spring, posso usar os recursos de DI.

    @Around("@annotation(com.picpay.aop.demo.infrastructure.aspects.suppressexception.SuppressException)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (Exception e) {
            return null;
        }
    }
}
