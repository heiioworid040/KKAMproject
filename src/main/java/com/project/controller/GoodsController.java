package com.project.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.domain.GoodsDTO;
import com.project.service.GoodsService;

@Controller
public class GoodsController {
	
	@Inject
	private GoodsService goodsService;
	
	@RequestMapping(value = "/goods/form", method = RequestMethod.GET)
	public String goodsForm(Model model) {
		GoodsDTO goodsDTO=new GoodsDTO();
		//검색 추가 예정
		
		List<GoodsDTO> GoodsList=goodsService.goodsList(goodsDTO);
		
		model.addAttribute("GoodsList", GoodsList);
		return "goods/form";
	}
	
	@RequestMapping(value = "/goods/details", method = RequestMethod.GET)
	public String goodsDetails(HttpServletRequest request, Model model) {
		GoodsDTO goodsDTO=new GoodsDTO();
		goodsDTO.setG_code(request.getParameter("G_code"));
		//검색 추가 예정

		List<GoodsDTO> GoodsList=goodsService.goodsList(goodsDTO);
		
		model.addAttribute("GoodsList", GoodsList);
		return "goods/details";
	}

	@RequestMapping(value = "/goods/goodsWrite", method = RequestMethod.GET)
	public String goodsWrite() {
		return "goods/goodsWrite";
	}
	
	@RequestMapping(value = "/goods/goodsWritePro", method = RequestMethod.GET)
	public String goodsWritePro(HttpServletRequest request) {
		GoodsDTO goodsDTO=new GoodsDTO();
		goodsDTO.setG_code(request.getParameter("code"));
		goodsDTO.setG_stop(Integer.parseInt(request.getParameter("stop")));
		goodsDTO.setG_product(request.getParameter("product"));
		goodsDTO.setG_price(Integer.parseInt(request.getParameter("price")));
		goodsDTO.setG_desc(request.getParameter("desc"));
		goodsDTO.setG_imgS(request.getParameter("imgS"));
		goodsDTO.setG_img(request.getParameter("img"));
		
		goodsService.goodsWrite(goodsDTO);
		
		return "redirect:/goods/goodsWrite";
	}
	
}