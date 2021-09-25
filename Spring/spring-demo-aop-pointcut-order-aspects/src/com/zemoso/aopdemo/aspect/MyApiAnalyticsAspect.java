package com.zemoso.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
