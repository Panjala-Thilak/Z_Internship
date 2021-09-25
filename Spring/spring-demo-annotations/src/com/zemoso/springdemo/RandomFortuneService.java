package com.zemoso.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService{
	
	private String[] data= {
			"Beware their is danger ahead",
			"wear a blue color dress"
	};
	
	private Random myRandom=new Random();
	    @Override
	    public String getFortune() {
	    	
	    	int index=myRandom.nextInt(data.length);
	    	String fortune=data[index];
	        return fortune;
	    }

}
