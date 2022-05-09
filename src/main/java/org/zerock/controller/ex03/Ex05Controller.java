package org.zerock.controller.ex03;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex05")
public class Ex05Controller {
	
	@RequestMapping("sub01")
	public void method01(HttpServletRequest request) {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		
		Customer cs = new Customer();
		cs.setName(name);
		cs.setAge(age);
		cs.setAddress(address);
		
		System.out.println(cs);
	}
	
	@RequestMapping("sub02")
	public void method02(Customer cs) {
		System.out.println(cs);
	}
	
	@RequestMapping("sub03")
	public void method03(@ModelAttribute Customer cs) {
		System.out.println(cs);
	}
	
	@RequestMapping("sub04")
	public void method04(Computer com) {
		System.out.println(com);
	}
	
	@RequestMapping("sub05")
	public void method05(Employee emp) {
		System.out.println(emp);
	}
}
