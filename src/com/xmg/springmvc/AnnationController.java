package com.xmg.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnnationController {
	@RequestMapping("/method1")
	public ModelAndView method(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("method1");
		System.out.println("in");
		return null;
	}
	
	@RequestMapping("/method2")
	public ModelAndView method2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("method2");
		return null;
	}
	
	@RequestMapping("/method3")
	public ModelAndView method3(HttpServletResponse response,HttpServletRequest request) throws Exception {
		System.out.println("method3");
		return null;
	}
	
	
	@RequestMapping("/method4")
	public ModelAndView method4(HttpServletResponse response,HttpSession session) throws Exception {
		System.out.println("method4   "+session);
		return null;
	}
	
	@RequestMapping("/method5")
	public ModelAndView method5(HttpServletResponse response,String name) throws Exception {
		System.out.println("method5   "+name);
		return null;
	}
}
