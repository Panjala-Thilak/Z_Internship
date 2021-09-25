package com.zemoso.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "helloworld-form";
	}
	@RequestMapping("/processForm")
	public String ProcessForm()
	{
		return "helloworld";
	}
	
	//new controller to read form data
	@RequestMapping("/processFormVersionTwo")
	public String shoutDude(HttpServletRequest request,Model model)
	{
		//read the req parameter
		String theName=request.getParameter("studentName");
		
		theName= theName.toUpperCase();
		
		String result="Yo! "+theName;
		
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName,Model model)
	{
		
		theName= theName.toUpperCase();
		
		String result="This is Version 3!!!! "+theName;
		
		model.addAttribute("message",result);
		
		return "helloworld";
	}
}
