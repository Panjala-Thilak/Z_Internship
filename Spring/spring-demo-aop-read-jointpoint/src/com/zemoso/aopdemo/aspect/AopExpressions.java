package com.zemoso.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.zemoso.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){};

    @Pointcut("execution(* com.zemoso.aopdemo.dao.*.get*(..))")
    public void getterMethods(){}

    @Pointcut("execution(* com.zemoso.aopdemo.dao.*.set*(..))")
    public void setterMethods(){}

    @Pointcut("forDaoPackage() && !(getterMethods() || setterMethods())")
    public void withoutGetterAndSetterMethods(){}

}
