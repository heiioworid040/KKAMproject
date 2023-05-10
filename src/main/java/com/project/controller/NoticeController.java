package com.project.controller;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class NoticeController {
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/notice/write", method = RequestMethod.GET)
	public String write() {
		return "notice/writeForm";
	}

}
