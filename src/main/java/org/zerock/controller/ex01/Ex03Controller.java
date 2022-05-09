package org.zerock.controller.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex03")
public class Ex03Controller {
	
	@RequestMapping("sub01")
	public void method01() {
		System.out.println("03controller 01method sub01");
	}
	
	@RequestMapping(value = "sub01", params = "name")
	public void method02() {
		System.out.println("03controller 02method sub01 name parameter");
	}
	
	@RequestMapping(value = "sub01", params = {"name", "age"})
	public void method03() {
		System.out.println("03controller 03method sub01 name, age parameter");
	}
}
