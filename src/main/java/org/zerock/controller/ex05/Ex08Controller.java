package org.zerock.controller.ex05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.controller.ex03.Customer;
import org.zerock.controller.ex03.Employee;

@Controller
@RequestMapping("ex08")
public class Ex08Controller {
	
	@RequestMapping("sub01")
	public String method01(HttpServletRequest req) {
		req.setAttribute("address", "Seoul");
		return "ex08/sub01";
	}
	
	@RequestMapping("sub02")
	public String method02(Model model) {
		model.addAttribute("address", "London");
		return "ex08/sub01";
	}
	
	@RequestMapping("sub03")
	public String metod03(Model model) {
		model.addAttribute("myName", "ABC");
		model.addAttribute("myAge", 10);
		return "ex08/sub03";
	}
	
	@RequestMapping("sub04")
	public void method04(Model model) {
		model.addAttribute("foods", new String[] {"apple", "milk", "coffee"});
	}
	
	@RequestMapping("sub05")
	public void method05(Model model) {
		List<String> list = new ArrayList<>();
		list.add("Iron Man");
		list.add("Spider Man");
		list.add("Doctor Strange");
		
		model.addAttribute("heroList", list);
//		model.addAttribute("heroList", new String[] {"Iron Man", "Spider Man", "Doctor Strange"});
	}
	
	@RequestMapping("sub06")
	public void method06(Model model) {
		Map<String, String> map = new HashMap<>();
		map.put("name", "jin");
		map.put("song", "butter");
		map.put("group", "bts");
		
		model.addAttribute("desc", map);
	}
	
	@RequestMapping("sub07")
	public void method07(Model model) {
		Customer cs = new Customer();
		cs.setAddress("Seoul");
		cs.setAge(30);
		cs.setName("ABC");
		model.addAttribute("customer", cs);
	}
	
	@RequestMapping("sub08")
	public void method08(Model model) {
		Employee emp = new Employee();
		emp.setEmail("aaa@abc.bcd");
		emp.setSalary(50000);
		emp.setName("ABC");
		
		model.addAttribute("employee", emp);
	}
	
	@RequestMapping("sub09")
	public String method09(Model model) {
		Employee emp = new Employee();
		emp.setEmail("email@email.com");
		emp.setName("ABC");
		emp.setSalary(10000);
		
		// attribute 이름이 클래스의 이름으로 결정(lowerCamelCase형식)
		// model.addAttribute("employee", emp)와 같음
		model.addAttribute(emp);	
		
		return "ex08/sub08";
	}
	
	@RequestMapping("sub10")
	public String method10(Model model) {
		Customer cs = new Customer();
		cs.setAddress("London");
		cs.setAge(20);
		cs.setName("AAA");
		
		model.addAttribute(cs);
		
		return "ex08/sub07";
	}
	
	@RequestMapping("sub11")
	public void method11(Model model) {
		List<String> list = new ArrayList<>();
		
		list.add("wanda");
		list.add("doctor");
		list.add("wong");
		
		model.addAttribute("list", list);
	}
}
