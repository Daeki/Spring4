package com.iu.s4.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@PostMapping("update")
	public ModelAndView setUpdate(MemberDTO memberDTO, HttpSession session)throws Exception{
		//수정전 데이터
		MemberDTO sessionDTO = (MemberDTO)session.getAttribute("member");
		
		//수정후 데이터
		memberDTO.setId(sessionDTO.getId());
		
		int result = memberService.setUpdate(memberDTO);
		
		memberDTO.setName(sessionDTO.getName());
		
		session.setAttribute("member", memberDTO);
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		return mv;
	}
	
	
	@GetMapping("update")
	public ModelAndView setUpdate()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/update");
		return mv;
	}
	
	
	@GetMapping("delete")
	public ModelAndView setDelete(HttpSession session)throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		int result = memberService.setDelete(memberDTO);
		//session.invalidate();
		ModelAndView mv = new ModelAndView();
		//mv.setViewName("redirect:../");
		mv.setViewName("redirect:./logout");
		return mv;
		
	}
	
	
	
	
	
	
	@GetMapping("mypage")
	public ModelAndView mypage()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/mypage");
		return mv;
	}
	
	@GetMapping("logout")
	public ModelAndView logout (HttpSession session)throws Exception{
		//1. 
		//session.removeAttribute("member");
		
		//2. 세션의 시간을 0
		session.invalidate();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@PostMapping("login")
	public ModelAndView login(MemberDTO memberDTO, HttpSession session)throws Exception{
		//HttpSession session= request.getSession();
		
		ModelAndView mv = new ModelAndView();
		memberDTO = memberService.getLogin(memberDTO);
		if(memberDTO != null) {
			System.out.println("로그인 성공");
			session.setAttribute("member", memberDTO);
		}else {
			System.out.println("로그인 실패");
		}
		
		mv.setViewName("redirect:../");
		
		return mv;
	}
	
	@GetMapping("login")
	public ModelAndView login()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/login");
		return mv;
	}
	
	@GetMapping("idCheck")
	public ModelAndView getIdCheck(MemberDTO memberDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		memberDTO = memberService.getIdCheck(memberDTO);
		System.out.println("id 중복 체크");
		mv.addObject("dto", memberDTO);
		mv.setViewName("member/idCheck");
		
		return mv;
		
	}
	
	@PostMapping("join")
	public ModelAndView join(MemberDTO memberDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = memberService.setJoin(memberDTO);
		
		mv.setViewName("redirect:../");
		
		return mv;
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