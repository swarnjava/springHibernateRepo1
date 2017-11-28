package com.swarn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingController {

	
	@RequestMapping("/openApp")
	public ModelAndView openApplication()
	{
		ModelAndView mav=new ModelAndView();
		
		System.out.println("********* HELO ****************** ");
		mav.setViewName("home");
		return mav;
	}
	
	
	@RequestMapping("/hello")
	public String sendRest(@RequestHeader(value="Accept") String accept,
			@RequestHeader(value="Accept-Language") String acceptLanguage,
			@RequestHeader(value="User-Agent", defaultValue="foo") String userAgent,
			@RequestHeader("authorization") String authString,
			HttpServletResponse response,HttpServletRequest request)
			{
		
		System.out.println("accept: " + accept);
		System.out.println("acceptLanguage: " + acceptLanguage);
		System.out.println("userAgent: " + userAgent);
		
		System.out.println("AuthStr before decrypt: "+authString);
		System.out.println("Data: "+request.getParameter("param1"));
		
		return null;
			}
}
