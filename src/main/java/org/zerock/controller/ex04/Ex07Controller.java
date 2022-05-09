package org.zerock.controller.ex04;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex07")
public class Ex07Controller {

	@RequestMapping("sub01")
	public String method01() {
		
		return "redirect:https://www.naver.com";
	}
	
//	@RequestMapping("sub02")
//	public String method02(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		// /ex07/sub02
//		// /ex06/sub01로 redirection
//		
//		String location = request.getContextPath() + "/ex06/sub01";
//		response.sendRedirect(location);
//		
//		return null;
//	}
	
	@RequestMapping("sub02")
	public String method02() {
		
		return "redirect:/ex06/sub01";
	}
	
	@RequestMapping("sub03")
	public String method03() {
		return "redirect:/ex06/sub05";
	}
}
