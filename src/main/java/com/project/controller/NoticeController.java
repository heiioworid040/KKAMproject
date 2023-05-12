package com.project.controller;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.project.domain.NoticeDTO;
import com.project.service.NoticeService;


@Controller
public class NoticeController {
	
	@Inject
	private NoticeService noticeService;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/notice/write", method = RequestMethod.GET)
	public String write() {
		return "notice/writeForm";
	}
	
	@RequestMapping(value = "/notice/writePro", method = RequestMethod.POST)
	public String writePro(HttpServletRequest request, MultipartFile file) throws Exception {
	
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setN_text(request.getParameter("text"));
		noticeDTO.setN_title(request.getParameter("title"));
		noticeDTO.setU_id(request.getParameter("id"));
		noticeDTO.setU_nick(request.getParameter("nick"));
		
		UUID uuid = UUID.randomUUID();
		String filename = uuid.toString() + "_" + file.getOriginalFilename();
		FileCopyUtils.copy(file.getBytes(), new File(uploadPath,filename));
		noticeDTO.setN_img(filename);
		
		noticeService.insertNotice(noticeDTO);
		return "redirect/notice/list";
	
	}

	
}
