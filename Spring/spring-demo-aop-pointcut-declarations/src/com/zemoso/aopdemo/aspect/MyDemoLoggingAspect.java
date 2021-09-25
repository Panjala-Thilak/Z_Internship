package com.zemoso.aopdemo.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {


    @Pointcut("execution(* com.zemoso.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){};

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice()
    {
        System.out.println("-->Executing  before advice method");
    }

    @After("forDaoPackage()")
    public void afterAddAccountAdvice()
    {
        System.out.println("-->Executing  after advice method\n");
    }
}
