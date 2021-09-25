package com.zemoso.aopdemo.aspect;


import com.zemoso.aopdemo.Account;
import com.zemoso.aopdemo.AroundWithLoggerDemoApp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private static Logger myLogger=Logger.getLogger(AroundWithLoggerDemoApp.class.getName());


    @Around("execution(* com.zemoso.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String method=proceedingJoinPoint.getSignature().toShortString();
        myLogger.info("--> executing @Around  on method: "+method);

        long begin=System.currentTimeMillis();

        Object result=null;
        try {
            result = proceedingJoinPoint.proceed();
        }
        catch (Exception exc)
        {
            myLogger.warning(exc.getMessage());

           // result="Major accident!But no worries, your private AOP helicopter is on the way!";

            throw exc;
        }
        long end=System.currentTimeMillis();

        long duration=end-begin;

        myLogger.info("\n-->Duration : "+duration/1000.0+" seconds");

        return result;
    }

    @After("execution(* com.zemoso.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method=joinPoint.getSignature().toShortString();
        System.out.println("--> executing @After (finally) on method: "+method);

    }

    @AfterThrowing(pointcut = "execution(* com.zemoso.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing="exc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint,Throwable exc)
    {
        String method=joinPoint.getSignature().toShortString();
        System.out.println("--> executing @AfterThrowing on method: "+method);

        System.out.println("-->The Exception is : "+exc);

    }
    @AfterReturning(pointcut = "execution(* com.zemoso.aopdemo.dao.AccountDAO.findAccounts(..))",
                    returning="result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result)
    {

        String method=joinPoint.getSignature().toShortString();
        System.out.println("--> executing @AfterReturning on method: "+method);

        System.out.println("-->result is : "+result);

        convertAccountNamesToUpperCase(result);

        System.out.println("-->result after modifying  : "+result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account tempAccount:result) {
                String upperName=tempAccount.getName().toUpperCase();
                tempAccount.setName(upperName);
        }
    }

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
