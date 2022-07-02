package com.springbootsandbox.aspect.validation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ValidationAspect {

    //verifies that the argument is a positive long
    //we use around to be able to stop the method thanks to the proceedingJoinPoint
    @Around("execution(* com.springbootsandbox.controller.CatController.getCat(..))")
    public Object validateArg(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            Long arg = (Long) proceedingJoinPoint.getArgs()[0];
            if (arg < 0) {
                log.error("bad argument");
                return null;
            } else {
                return proceedingJoinPoint.proceed();
            }
        } catch (ClassCastException e) {
            log.error("bad argument type");
            return null;
        }
    }
}
