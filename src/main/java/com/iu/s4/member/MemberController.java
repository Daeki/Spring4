package com.iu.s4.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("idCheck")
	public void getIdCheck(MemberDTO memberDTO)throws Exception{
		memberDTO = memberService.getIdCheck(memberDTO);
		System.out.println("id 중복 체크");
	}
	
	
	
	@GetMapping("join")
	public ModelAndView join()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/join");
		return mv;
	}
	
	
	@GetMapping("check")
	public ModelAndView check()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/check");
		return mv; 
	}
	

}
