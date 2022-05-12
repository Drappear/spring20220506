package org.zerock.controller.ex10;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.ex02.BoardDto;
import org.zerock.service.ex03.Ex05Service;

@Controller
@RequestMapping("ex15")
public class Ex15Controller {
	
	@Autowired
	private Ex05Service service;
	
	@RequestMapping("sub01")
	public String method01(Model model, int id) {
		String name = service.getCustomerNameById(id);
		model.addAttribute("name", name);
		return "/ex14/sub01";
	}
	
	@RequestMapping("sub02")
	public String method02(Model model, int id) {
		String name = service.getEmployeeFirstNameById(id);
		
		model.addAttribute("firstName", name);
		return "/ex14/sub02";
	}
	
	@GetMapping("board/list")
	public void listBoard(Model model) {
		List<BoardDto> list = service.listBoard();
		
		model.addAttribute("boardList", list);
	}
	
	@GetMapping("board/{id}")
	public String getBoard(Model model, @PathVariable("id") int id) {
		BoardDto dto = service.getBoard(id);
		
		model.addAttribute("boardDto", dto);
		return "ex15/board/get";
	}
	
	@PostMapping("board/modify")
	public String modifyBoard(BoardDto board) {
		boolean success = service.updateBoard(board);
		
		if(success) {
			
		} else {
			
		}
		return "redirect:/ex15/board/" + board.getId();
	}
}
