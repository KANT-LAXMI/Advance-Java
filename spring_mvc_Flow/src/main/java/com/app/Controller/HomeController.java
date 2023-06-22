package com.app.Controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	public HomeController() {
		System.out.println("in HomeController constructor"+getClass());
	}
	@RequestMapping("/")
	public ModelAndView ShowHomePage(){
		System.out.println("in home page");
		return new ModelAndView("/index", "hello", LocalDateTime.now());
		
	}
}
