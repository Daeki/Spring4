package com.iu.s4.member;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	public int setUpdate(MemberDTO memberDTO)throws Exception{
		return memberDAO.setUpdate(memberDTO);
	}
	
	public int setDelete(MemberDTO memberDTO)throws Exception{
		return memberDAO.setDelete(memberDTO);
	}
	
	public int setJoin(MemberDTO memberDTO, MultipartFile photo, HttpSession session)throws Exception{
		//1. 어느 폴더에 저장
		// /resources/upload/member
		//2. application(ServletContext) 객체 필요
		ServletContext sContext = session.getServletContext();
		String realPath = sContext.getRealPath("/resources/upload/member/");
		System.out.println("RealPath : "+realPath);
		
		
		return 0; //memberDAO.setJoin(memberDTO);
	}
	
	public MemberDTO getLogin(MemberDTO memberDTO)throws Exception{
		return memberDAO.getLogin(memberDTO);
	}
	
	public MemberDTO getIdCheck(MemberDTO memberDTO)throws Exception{
		return memberDAO.getIdCheck(memberDTO);
	}

}
