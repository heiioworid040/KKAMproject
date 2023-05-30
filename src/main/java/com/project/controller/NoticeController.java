package com.project.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.project.domain.CommentDTO;
import com.project.domain.NoticeDTO;
import com.project.domain.PageDTO;
import com.project.service.NoticeService;


@Controller
public class NoticeController {
	
	@Inject
	private NoticeService noticeService;
	
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	
	@RequestMapping(value = "/notice/write", method = RequestMethod.GET)
	public String write() {
		return "notice/write";
	}
	
	
	@RequestMapping(value = "/notice/writePro", method = RequestMethod.POST)
	public String writePro(HttpServletRequest request, MultipartFile img) throws Exception {
		
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setN_text(request.getParameter("text"));
		noticeDTO.setN_title(request.getParameter("title"));
		noticeDTO.setU_id(request.getParameter("id"));
		
		UUID uuid = UUID.randomUUID();
		String filename = uuid.toString() + "_" + img.getOriginalFilename();
		FileCopyUtils.copy(img.getBytes(), new File(uploadPath,filename));
		noticeDTO.setN_img(filename);
		
		noticeService.insertNotice(noticeDTO);
		return "redirect:/notice/notice";	
	}
	
	
	@RequestMapping(value = "/notice/notice", method =  RequestMethod.GET)
	public String list(HttpServletRequest request, Model model) {
		
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		
		PageDTO pageDTO = new PageDTO();
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
		
		List<NoticeDTO> noticeList = noticeService.getNoticeList(pageDTO);
		
		int count = noticeService.getNoticeCount(pageDTO);
		int pageBlock=10;
		int startPage=(currentPage-1)/pageBlock*pageBlock+1;
		int endPage=startPage+pageBlock-1;
		int pageCount=count/pageSize+(count%pageSize==0?0:1);
		if(endPage > pageCount){
			endPage = pageCount;
		}
		
		pageDTO.setCount(count);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pageDTO", pageDTO);
		
		return "notice/notice";
	}

	@RequestMapping(value = "/notice/content", method =  RequestMethod.GET)
	public String content(HttpServletRequest request, Model model) {
		int N_num = Integer.parseInt(request.getParameter("N_num"));
		
		NoticeDTO noticeDTO = noticeService.getNotice(N_num);
		
		model.addAttribute("noticeDTO", noticeDTO);
		
		return "notice/content";
		
	}
	
	@RequestMapping(value = "/notice/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request, Model model) {
		int N_num = Integer.parseInt(request.getParameter("N_num"));
		
		NoticeDTO noticeDTO=noticeService.getNotice(N_num);
		
		model.addAttribute("noticeDTO", noticeDTO);

		return "notice/update";
	}
	
	@RequestMapping(value = "/notice/updatePro", method = RequestMethod.POST)
	public String updatePro(HttpServletRequest request, MultipartFile img) throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setN_num(Integer.parseInt(request.getParameter("num")));
		noticeDTO.setN_text(request.getParameter("text"));
		noticeDTO.setN_title(request.getParameter("title"));
		noticeDTO.setU_id(request.getParameter("id"));				
		
		if(img.isEmpty()) {
			noticeDTO.setN_img(request.getParameter("oldimg"));
		}else {
			UUID uuid=UUID.randomUUID();
			String imgname=uuid.toString()+"_"+img.getOriginalFilename();
			FileCopyUtils.copy(img.getBytes(), new File(uploadPath,imgname));
			
			noticeDTO.setN_img(imgname);
		}
				
		noticeService.update(noticeDTO);
		return "redirect:/notice/notice";
	}
	
	@RequestMapping(value = "/notice/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int N_num=Integer.parseInt(request.getParameter("N_num"));
		
		noticeService.delete(N_num);
		
		// 주소변경 하면서 이동
		return "redirect:/notice/notice";
	}
	
	@RequestMapping(value = "/notice/noticePro", method = RequestMethod.POST)
	public String noticePro(HttpServletRequest request) throws Exception {
		
		CommentDTO commentDTO = new CommentDTO();
		
		commentDTO.setU_id(request.getParameter("id"));
		commentDTO.setC_cont(request.getParameter("cont"));
		commentDTO.setN_num(Integer.parseInt(request.getParameter("num")));
		
		noticeService.insertComment(commentDTO);
		return "redirect:/notice/notice";	
	}
	
	
	
	
	
}
