package com.iu.s4.board.notice;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.BoardFilesDTO;
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
	
	public List<BoardFilesDTO> getFiles(BoardDTO boardDTO)throws Exception{
		return noticeDAO.getFiles(boardDTO);
	}

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
		
		//List<BoardFilesDTO> ar = noticeDAO.getFiles(boardDTO);
		
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
		
		System.out.println("Before Num : "+boardDTO.getNum());
		
		int result = noticeDAO.setInsert(boardDTO);
		
		System.out.println("After Num : "+boardDTO.getNum());
		
		for(MultipartFile multipartFile:files) {
			String fileName = fileManager.fileSave(multipartFile, file);
			System.out.println(fileName);
			BoardFilesDTO boardFilesDTO = new BoardFilesDTO();
			boardFilesDTO.setFileName(fileName);
			boardFilesDTO.setOriName(multipartFile.getOriginalFilename());
			boardFilesDTO.setNum(boardDTO.getNum());
			
			result = noticeDAO.setFile(boardFilesDTO);
		}
		
		
		
		return result;// noticeDAO.setInsert(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		//Files Table에서 삭제할 파일명들 조회
		List<BoardFilesDTO> ar = noticeDAO.getFiles(boardDTO);
		
		//어느 폴더
		String realPath = servletContext.getRealPath("/resources/upload/notice/");
		for(BoardFilesDTO bDto: ar) {
			File file = new File(realPath, bDto.getFileName());
			fileManager.fileDelete(file);
		}
		
		
		//DB 삭제
				
		return noticeDAO.setDelete(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
