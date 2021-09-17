package com.iu.s4.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.BoardFilesDTO;
import com.iu.s4.board.CommentsDTO;
import com.iu.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	//setComment
	@PostMapping("comment")
	public void setComment(CommentsDTO commentsDTO)throws Exception{
		commentsDTO.setBoard("N");
		
	}
	
	
	
	@GetMapping("down")
	public ModelAndView fileDown(BoardFilesDTO boardFilesDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", boardFilesDTO);
		mv.setViewName("fileDown");
		return mv;
	}
	
	@GetMapping("delete")
	public ModelAndView setDelete(BoardDTO boardDTO)throws Exception{
		int result = noticeService.setDelete(boardDTO);
		ModelAndView mv = new ModelAndView();
		String message="Delete Fail";
		if(result>0) {
			message = "Delete Success";
		}
		
		mv.addObject("msg", message);
		mv.addObject("url", "./list");
		
		mv.setViewName("common/result");
		
		return mv;
	}
	
	
	@GetMapping("select")
	public ModelAndView getSelect(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getSelect(boardDTO);
		List<BoardFilesDTO> ar = noticeService.getFiles(boardDTO);
//		mv.addObject("fileList", ar);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/select");
		return mv;
	}
	
	
	@GetMapping("insert")
	public String setInsert()throws Exception{
		System.out.println("test");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/insert");
		return "board/insert";
	}
	
	@PostMapping("insert")
	public ModelAndView setInsert(BoardDTO boardDTO, MultipartFile [] files)throws Exception{
		//original file name 출력
		for(MultipartFile muFile: files) {
			System.out.println(muFile.getOriginalFilename());
		}
		
		
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setInsert(boardDTO, files);
		
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
	
//	@RequestMapping(value = "list", method = RequestMethod.GET)
	@GetMapping("list")
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/list");
		
		List<BoardDTO> ar = noticeService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		
		return mv;
	}

}
