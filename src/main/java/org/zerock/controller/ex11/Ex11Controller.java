package org.zerock.controller.ex11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("ex11")
public class Ex11Controller {
	
//	@RequestMapping(value = "login", method = RequestMethod.GET)
	@GetMapping("login")
	public void loginForm() {
		System.out.println("login form forward");
	}
	
//	@RequestMapping(value = "login", method = RequestMethod.POST)
	@PostMapping("login")
	public String loginProcess(String id, String password, RedirectAttributes rttr) {
		System.out.println("login process");
		
		boolean ok = false;
		if(id != null && id.equals(password)) {
			ok = true;
		}
		
		if(ok) {
			rttr.addFlashAttribute("message", "login success");
			
			return "redirect:/ex11/main";
		} else {
			rttr.addFlashAttribute("message", "login failed");
			
			return "redirect:/ex11/login";
		}
	}
	
	@GetMapping("main")
	public void main() {
		
	}
}
