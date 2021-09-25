package com.zemoso.aopdemo;

import com.zemoso.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {

    private static Logger myLogger=Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService=context.getBean("trafficFortuneService",TrafficFortuneService.class);

        myLogger.info("\n Main Program : AroundDemoApp");

        myLogger.info("calling getFortune");


        boolean tripWire=true;
        String data=trafficFortuneService.getFortune(tripWire);

        myLogger.info("\nMy fortune is : "+data);

        myLogger.info("Done!!");

        context.close();

    }
}
