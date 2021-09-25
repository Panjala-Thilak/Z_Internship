package com.zemoso.aopdemo;

import com.zemoso.aopdemo.dao.AccountDAO;
import com.zemoso.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService=context.getBean("trafficFortuneService",TrafficFortuneService.class);

        System.out.println("\n Main Program : AroundDemoApp");

        System.out.println("calling getFortune");

        String data=trafficFortuneService.getFortune();

        System.out.println("\nMy fortune is : "+data);

        System.out.println("Done!!");

        context.close();

    }
}
