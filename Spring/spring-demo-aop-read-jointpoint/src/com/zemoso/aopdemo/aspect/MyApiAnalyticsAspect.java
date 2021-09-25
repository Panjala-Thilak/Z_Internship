package com.zemoso.aopdemo.aspect;

import com.zemoso.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(10)
public class MyApiAnalyticsAspect {
    @Before("AopExpressions.withoutGetterAndSetterMethods()")
    public void performApiAnalytics()
    {
        System.out.println("-->Performing API analytics");
    }

}
