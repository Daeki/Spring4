package com.iu.s4.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s4.member.MemberDTO;

@Component
public class AdminInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//admin
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		boolean result=false;
		if(memberDTO != null && memberDTO.getId().equals("admin")) {
			result=true;
		}else {
			//1. redirect
			//response.sendRedirect("../member/login");
			//2. forward
			request.setAttribute("msg", "관리자만 가능");
			request.setAttribute("url", "../member/login");
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		return result;
	}
	
	

}
