package com.picpay.aop.demo.infrastructure.aspects.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggerAspect {

    @Pointcut("@annotation(com.picpay.aop.demo.infrastructure.aspects.logger.Logger)")
    public void pointcutLogger() {
    }

    @Pointcut("within(com.picpay.aop.demo.infrastructure.controllers..*)")
    public void inControllerLayer() {
    }

    @Before("pointcutLogger() && inControllerLayer()")
    public void beforeAdvice(JoinPoint joinPoint) {
        MethodSignature method = (MethodSignature) joinPoint.getSignature();

        Logger loggerAnnotation = method.getMethod().getAnnotation(Logger.class);

        var log = LoggerFactory.getLogger(loggerAnnotation.value());

        log.info("Method invoked - LoggerAdvice");
    }
}
