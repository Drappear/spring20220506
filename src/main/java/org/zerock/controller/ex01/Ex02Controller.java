package org.zerock.controller.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex02")	// '/' 생략 가능
public class Ex02Controller {
	
	@RequestMapping("/sub01")
	public void method01() {
		System.out.println("02controller 01method");
	}
	
	@RequestMapping("sub02")
	public void method02() {
		System.out.println("02controller 02method");
	}
	
	@RequestMapping(value= "sub03")
	public void method03() {
		System.out.println("02controller 03method(value)");
	}
	
	@RequestMapping({"sub04", "sub05"})
	public void method04() {
		System.out.println("02controller 04method(sub4,sub5)");
	}
	
	@RequestMapping(value= {"sub06", "sub07"})
	public void method05() {
		System.out.println("02controller 05method(sub6,sub7/value)");
	}
	
	@RequestMapping(path = "sub08")
	public void method06() {
		System.out.println("02controller 06method(sub08/path)");
	}
	
	@RequestMapping(path = {"sub09", "sub10"})
	public void method07() {
		System.out.println("02controller 07method(sub09, sub10/path)");
	}
}
