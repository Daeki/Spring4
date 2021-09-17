package com.iu.s4.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.s4.board.BoardFilesDTO;

@Component
public class FileDown extends AbstractView {
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// //model -> Controller 의 Model
	
		//폴더명
		String board = (String)model.get("board");
		
		//filename
		BoardFilesDTO boardFilesDTO = (BoardFilesDTO)model.get("dto");
		
		
		//realPath
		board = request.getSession().getServletContext().getRealPath("/resources/upload/"+board);
		
		
		File file = new File(board, boardFilesDTO.getFileName());
		
		//한글처리
		response.setCharacterEncoding("UTF-8");
		
		//파일크기
		response.setContentLength((int)file.length());
		
		//다운시 파일 이름 인코딩
		//String downName = URLEncoder.encode(boardFilesDTO.getOriName(), "UTF-8");
		String fileName = boardFilesDTO.getFileName();
		String downName=fileName.substring(fileName.lastIndexOf("_")+1);
		//response header 설정
		response.setHeader("Content-Disposition", "attachment;fileName=\""+downName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//파일을 읽어서 Client 전송
		FileInputStream fi = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		FileCopyUtils.copy(fi, os);
		
		os.close();
		fi.close();
		
	}

}
