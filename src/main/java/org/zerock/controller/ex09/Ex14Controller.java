package org.zerock.controller.ex09;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ex01.CustomerDto;
import org.zerock.domain.ex01.EmployeeDto;
import org.zerock.domain.ex01.PageInfoDto;
import org.zerock.service.ex02.Ex04Service;

@Controller
@RequestMapping("ex14")
public class Ex14Controller {
	
	@Autowired
	private Ex04Service service;
	
	@RequestMapping("sub01")
	public void method01(int id, Model model) {
		String name = service.getNameById(id);
		
		model.addAttribute("name", name);
	}
	
	@RequestMapping("sub02")
	public void method02(int id, Model model) {
		String firstName = service.getFirstNameById(id);
		
		model.addAttribute("firstName", firstName);
	}
	
	@RequestMapping("sub03")
	public void method03(int id, Model model) {
		CustomerDto dto = service.getCustomerInfoById(id);
		
		model.addAttribute("customer", dto);
	}
	
	@RequestMapping("sub04")
	public void method04(int id, Model model) {
		EmployeeDto dto = service.getEmployeeInfoById(id);
		
		model.addAttribute("employee", dto);
	}
	
	@GetMapping("sub05")
	public void method05() {
		
	}
	
	@PostMapping("sub05")
	public String method06(CustomerDto customer, RedirectAttributes rttr) {
		boolean ok = service.addCustomer(customer);
		
		if(ok) {			
			rttr.addFlashAttribute("message", "입력 완료");
		} else {
			rttr.addFlashAttribute("message", "입력 실패");
		}
		
		return "redirect:/ex14/sub05";
	}
	
	@GetMapping("sub06")
	public void method07() {
		
	}
	
	@PostMapping("sub06")
	public String method08(EmployeeDto employee, RedirectAttributes rttr) {
		boolean ok = service.addEmployee(employee);
		
		if(ok) {
			rttr.addFlashAttribute("message", "success");
		} else {
			rttr.addFlashAttribute("message", "fail");
		}
		
		return "redirect:/ex14/sub06";
	}
	
	@GetMapping("sub07")
	public void employeeList(Model model) {
		List<EmployeeDto> list = service.listEmployee();
		
		model.addAttribute("employees", list);
	}
	
	@GetMapping("sub08")
	public void customerList(Model model, @RequestParam(name="page", defaultValue = "1")int page) {
		int  total = service.getTotal();
		
		int startPage = (page - 1) /10 * 10 + 1;
		int endPage = startPage + 9;
		int startRowNum = (page -1) * 10;
		int lastPage = (total - 1) / 10 +1;
		
		List<CustomerDto> list = service.listCustomer(startRowNum);
		model.addAttribute("customerList", list);
		
		endPage = Math.min(lastPage, endPage);
		
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("prevPage", startPage - 10);
		model.addAttribute("nextPage", startPage + 10);
		model.addAttribute("currentPage", page);
		model.addAttribute("lastPage", lastPage);
	}
	
	@GetMapping("sub09")
	public void method09(@RequestParam(name="page", defaultValue = "1")int page, Model model) {
		int rowPerPage = 5;
		int totalRecords = service.getTotal();
		int end = (totalRecords - 1) / rowPerPage + 1;
		
		List<CustomerDto> list = service.listCustomerPage(page, rowPerPage);
		
		PageInfoDto pageInfo = new PageInfoDto();
		pageInfo.setCurrent(page);
		pageInfo.setEnd(end);
		
		model.addAttribute("customerList", list);
		model.addAttribute("pageInfo", pageInfo);		
	}
}
