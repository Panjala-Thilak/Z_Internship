package com.zemoso.aopdemo.aspect;


import com.zemoso.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("AopExpressions.withoutGetterAndSetterMethods()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint)
    {
        System.out.println("-->Executing  before advice method");
        //display the method signature
        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();

        System.out.println("Method : "+methodSignature);

        //display method arguments
        Object[] args= joinPoint.getArgs();
        for (Object a:args) {
            System.out.println(a);
            if(a instanceof Account){
                Account account=(Account) a;
                System.out.println("account name: "+account.getName());
                System.out.println("account level: "+account.getLevel());
            }
        }
    }


}
