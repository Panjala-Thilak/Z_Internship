package com.zemoso.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach()
	{
		System.out.println("Inside default constructor");
	}
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService)
	{
		fortuneService=theFortuneService;
	}
	*/
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley for 30mins";
	}
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	@PostConstruct
	public void startupStuff()
	{
		System.out.println("startup stuff method");
	}
	
	@PreDestroy
	public void cleanupStuff()
	{
		System.out.println("cleanup stuff method");
	}
	
	
	/*
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside setter method");
		this.fortuneService = fortuneService;
	}
	*/
	
	/*
	@Autowired
	public void setInjection(FortuneService fortuneService){
		System.out.println("Inside the setinjection method");
		this.fortuneService = fortuneService;
	}
	*/
	
	
}
