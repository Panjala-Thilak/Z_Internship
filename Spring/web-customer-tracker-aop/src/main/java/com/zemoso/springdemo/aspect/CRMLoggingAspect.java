package com.zemoso.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    private Logger myLogger=Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.zemoso.springdemo.controller.*.*(..))")
    private void forControllerPackage()
    {
    }

    @Pointcut("execution(* com.zemoso.springdemo.service.*.*(..))")
    private void forServicePackage()
    {
    }

    @Pointcut("execution(* com.zemoso.springdemo.dao.*.*(..))")
    private void forDAOPackage()
    {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint)
    {
        String method=joinPoint.getSignature().toShortString();

        myLogger.info("-->@Before : calling method "+method);

        Object[] args=joinPoint.getArgs();

        for (Object tempArg:args) {
            myLogger.info("--->argument: "+tempArg);

        }
    }

    @AfterReturning(pointcut = "forAppFlow()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result)
    {
        String method=joinPoint.getSignature().toShortString();

        myLogger.info("-->@After Returning : calling method "+method);

        myLogger.info("result is : "+result);

    }



}
