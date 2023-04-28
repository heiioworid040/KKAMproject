package com.project.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.service.GoodsService;

@Controller
public class GoodsController {
	
	@Inject
//	private GoodsService goodsService;
	
	@RequestMapping(value = "/goods/form", method = RequestMethod.GET)
	public String goods() {
		
		return "goods/form";
	}
}