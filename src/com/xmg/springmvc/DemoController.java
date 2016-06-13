package com.xmg.springmvc;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
	//1.最原始的,使用serlvet-api中方法
	@RequestMapping("/demo1")
	public ModelAndView method(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("demo1");
		User u = new User();
		u.setUserName(request.getParameter("userName"));
		u.setPassword(request.getParameter("password"));
		System.out.println(u);
		return null;
	}
	//2,在方法参数列表中,直接定义前台需要传递过来的参数,基于同名匹配的规则进行注入的.
	@RequestMapping("/demo2")
	public ModelAndView method2(String[] userName,String password) throws Exception {
		System.out.println(Arrays.toString(userName));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/input.jsp");
		return mv;
	}
	
	//3.可以使用@RequestParam来解决前台参数和后台方法参数名不一致的情况.
	@RequestMapping("/demo3")
	public ModelAndView method3(@RequestParam(value="userName1")String userName,String password) throws Exception {
		System.out.println("demo3");
		User u = new User();
		u.setUserName(userName);
		u.setPassword(password);
		System.out.println(u);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/input.jsp");
		return mv;
	}
	
	//4.使用对象传参的方式
	@RequestMapping("/demo4")
	public ModelAndView method4(User u) throws Exception {
		System.out.println("demo4");
		System.out.println(u);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/input.jsp");
		return mv;
	}
	
	//5.使用地址栏传参   地址为:localhost:8080/delete/5   ---->5 作为参数传递
	@RequestMapping("/delete/{deleteId}")
	public ModelAndView method4(@PathVariable(value="deleteId")Long id) throws Exception {
		System.out.println("delete");
		System.out.println(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/input.jsp");
		return mv;
	}
	
	
}
