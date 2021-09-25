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

    @Pointcut("execution(* com.zemoso.aopdemo.dao.*.get*(..))")
    private void getterMethods(){}

    @Pointcut("execution(* com.zemoso.aopdemo.dao.*.set*(..))")
    private void setterMethods(){}

    @Pointcut("forDaoPackage() && !(getterMethods() || setterMethods())")
    private void withoutGetterAndSetterMethods(){}

    @Before("withoutGetterAndSetterMethods()")
    public void beforeAddAccountAdvice()
    {
        System.out.println("-->Executing  before advice method");
    }

    @After("withoutGetterAndSetterMethods()")
    public void afterAddAccountAdvice()
    {
        System.out.println("-->Executing  after advice method\n");
    }
}
