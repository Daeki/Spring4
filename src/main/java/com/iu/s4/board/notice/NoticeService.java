package com.iu.s4.board.notice;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.BoardService;
import com.iu.s4.util.FileManager;
import com.iu.s4.util.Pager;

@Service
public class NoticeService implements BoardService {
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = noticeDAO.getCount(pager);
		pager.makeNum(totalCount);
		pager.makeRow();
		
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		noticeDAO.setHitUpdate(boardDTO);
		return noticeDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		// TODO Auto-generated method stub
		//1. 어느 폴더 /resources/upload/notice/
		String realPath = servletContext.getRealPath("/resources/upload/notice/");
		System.out.println(realPath);
		File file = new File(realPath);
		
		for(MultipartFile multipartFile:files) {
			String fileName = fileManager.fileSave(multipartFile, file);
			System.out.println(fileName);
		}
		
		
		
		return 0;// noticeDAO.setInsert(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
