package com.castgroup.prova.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
	
	@RequestMapping("/home")
	public ModelAndView index() {
		return new ModelAndView("home");
	}
}
