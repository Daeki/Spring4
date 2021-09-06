package com.iu.s4.board.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	
//	@RequestMapping(value = "list", method = RequestMethod.GET)
	@GetMapping("list")
	public ModelAndView getList()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/list");
		return mv;
	}

}
