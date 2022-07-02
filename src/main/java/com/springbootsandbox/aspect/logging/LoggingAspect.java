package com.springbootsandbox.aspect.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    //will log something each time a method called getCats is called
    //it is possible to make this before after afterThrowing afterReturning or around
    //there are also many pointcut expressions to choose on what method to execute the aspect precisely
    @Before("execution(* *.getCats(..))")
    public void getterLog() {
        log.info("get cats");
    }

    //here we use to have a JointPoint as an argument and use it to have information about method arguments
    //we also precise the package because two methods in the code are called getCat
    @Before("execution(* com.springbootsandbox.controller.CatController.getCat(..))")
    public void getterLogId(JoinPoint joinPoint) {
        log.info("get cat " + joinPoint.getArgs()[0]);
    }
}
