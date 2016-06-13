package com.xmg.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorldController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("HelloWorldController.handleRequest()");
		String name = request.getParameter("name");
		/*request.setAttribute("9msg", "天气不错");
		request.getRequestDispatcher("/hello.jsp").forward(request, response);*/
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "天气不错");
		mv.setViewName("/hello.jsp");
		return mv;
	}
	
	

}
