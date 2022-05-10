package org.zerock.controller.ex05;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.controller.ex03.Customer;
import org.zerock.controller.ex03.Employee;

@Controller
@RequestMapping("ex09")
public class Ex09Controller {
	
	@RequestMapping("sub01")
	public void method01(String name, Model model) {
		System.out.println(name);
		model.addAttribute("name", name);
	}
	
	@RequestMapping("sub02")
	public String method02(@ModelAttribute("name") String name) {
		
		return "ex09/sub01";
	}
	
	@RequestMapping("sub03")
	public void method03(@ModelAttribute("address") String address, @ModelAttribute("email") String email ) {
		
	}
	
	@RequestMapping("sub04")
	public void method04(@ModelAttribute("customer") Customer cs) {
		
	}
	
	@RequestMapping("sub05")
	public String method05(@ModelAttribute Customer cs) {
		return "ex09/sub04";
	}
	
	@RequestMapping("sub06")
	public String method06(Customer cus) {
		return "ex09/sub04";
	}
	
	// 4, 5, 6모두 같은 역할 
	
	@RequestMapping("sub07")
	public void method07(Employee emp) {
		
	}
}
