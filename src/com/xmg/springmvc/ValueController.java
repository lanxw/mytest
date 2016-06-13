package com.xmg.springmvc;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ValueController {
	//1.使用最原始的方式,通过serlvetl api的方式
	@RequestMapping("/value1")
	public ModelAndView method(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("value11");
		//把数据放进域中
		request.setAttribute("msg", "今天天气不错哟");
		request.getRequestDispatcher("/hello.jsp").forward(request, response);
		return null;
	}
	//2.通过ModelAndView的对象设置模型和视图
	@RequestMapping("/value2")
	public ModelAndView method2() throws Exception {
		System.out.println("value12");
		ModelAndView mv = new ModelAndView();
		mv.addObject("小美");//通过通过这个方法存放值,是没有定义key,这里就会使用默认的key---->类型的全小写  string
		mv.addObject(new Date());//--->key:date
		mv.addObject(new User("小青","123"));//---->key:user
		mv.addObject(new User("小强","234"));//---->key:user,后定义的会覆盖前面的值s
		mv.setViewName("/hello.jsp");
		return mv;
	}
	
	//3.直接返回对象,是没有response和ModelAndView对象,
	//框架不知道如何去找到对应的视图,默认找的视图为localhost:8080/value3
	//告诉框架如何去处理这样的情况,需要定义一个视图解析器,来解决这个问题.
	//定义好视图解析器后,InternalResourceViewResolver,会添加前缀和后缀
	//相应的视图---->前缀+请求地址+后缀
	@RequestMapping("/value3")
	@ModelAttribute("u")
	public User method3() throws Exception {
		System.out.println("value3");
		return new User("小乐","8999988");
	}
	
	
	//4.返回字符串可以修改默认的视图名
	//默认的视图名称为:前缀+请求地址+后缀
	//使用字符串最为返回值,视图名变成    前缀+返回字符串+后缀
	//这时候,模型存放道什么地方呢?可以使用Model的参数来设置模型
	@RequestMapping("/value4")
	public String method4(Model model) throws Exception {
		model.addAttribute("msg", "我是返回值为string的方法");
		//此时地址为localhost:8080/hello.jsp转发到这个界面
		//return "forward:hello.jsp";
		//此时地址为localhost:8080/hello.jsp重定向到这个界面
		return "redirect:hello.jsp";
	}
	
}
