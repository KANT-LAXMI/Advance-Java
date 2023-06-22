package com.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	public BookController() {
	System.out.println("in Book Controller"+getClass());
	}
	@Autowired
	private BookService bkservice;
	@RequestMapping("/list")
	public ModelAndView bookDetails() {
		System.out.println("in bookcontroller method");
		return new ModelAndView("/book/list","bookList",bkservice.showAllBooks());
		
		
	}
}
