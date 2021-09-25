package com.zemoso.aopdemo.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("AopExpressions.withoutGetterAndSetterMethods()")
    public void beforeAddAccountAdvice()
    {
        System.out.println("-->Executing  before advice method");

    }


}
