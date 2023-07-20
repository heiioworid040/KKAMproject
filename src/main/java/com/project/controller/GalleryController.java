package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GalleryController {
	
	@RequestMapping(value = "/gallery/form", method = RequestMethod.GET)
	public String galleryForm() {
		return "gallery/form";
	}
}
