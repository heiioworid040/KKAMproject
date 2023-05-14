package com.project.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.project.domain.BasketDTO;
import com.project.domain.GoodsDTO;
import com.project.service.GoodsService;

@Controller
public class GoodsController {
	
	@Inject
	private GoodsService goodsService;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
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
	
	@RequestMapping(value = "/goods/basket", method = RequestMethod.GET)
	public String goodsbasket(HttpSession session, Model model) {
		BasketDTO bagDTO=new BasketDTO();
		bagDTO.setU_id((String)session.getAttribute("id"));
		//수정 예정
		
		List<BasketDTO> BasketList=goodsService.basketList(bagDTO);
		
		model.addAttribute("BasketList", BasketList);
		return "goods/basket";
	}
	
	@RequestMapping(value = "/goods/basketPro", method = RequestMethod.GET)
	public String goodsbasketPro(HttpSession session, HttpServletRequest request, Model model) {
		BasketDTO bagDTO=new BasketDTO();
		bagDTO.setU_id((String)session.getAttribute("id"));
		bagDTO.setG_code(request.getParameter("G_code"));
//		bagDTO.setB_count(request.getParameter("B_count"));

		goodsService.basketPro(bagDTO);
		
		return "redirect:/goods/basket";
	}

	@RequestMapping(value = "/goods/buy", method = RequestMethod.GET)
	public String goodsBuy(HttpServletRequest request, Model model) {
		GoodsDTO goodsDTO=new GoodsDTO();
		goodsDTO.setG_code(request.getParameter("G_code"));
		//검색 추가 예정

		List<GoodsDTO> GoodsList=goodsService.goodsList(goodsDTO);
		
		//장바구니 리스트로 수정 예정
		model.addAttribute("GoodsList", GoodsList);
		return "goods/buy";
	}

	@RequestMapping(value = "/goods/goodsWrite", method = RequestMethod.GET)
	public String goodsWrite() {
		return "goods/goodsWrite";
	}
	
	@RequestMapping(value = "/goods/goodsWritePro", method = RequestMethod.POST)
	public String goodsWritePro(HttpServletRequest request, MultipartFile img, MultipartFile imgS)throws Exception {
		GoodsDTO goodsDTO=new GoodsDTO();
		goodsDTO.setG_code(request.getParameter("code"));
		goodsDTO.setG_stop(Integer.parseInt(request.getParameter("stop")));
		goodsDTO.setG_product(request.getParameter("product"));
		goodsDTO.setG_price(Integer.parseInt(request.getParameter("price")));
		goodsDTO.setG_desc(request.getParameter("desc"));
		
		//파일 이름 수정 예정
		UUID uuid=UUID.randomUUID();
		String imgName=uuid.toString()+"_"+img.getOriginalFilename();
		String imgSName=uuid.toString()+"_"+imgS.getOriginalFilename();
		FileCopyUtils.copy(img.getBytes(), new File(uploadPath, imgName));
		FileCopyUtils.copy(imgS.getBytes(), new File(uploadPath, imgSName));
		
		goodsDTO.setG_img(imgName);
		goodsDTO.setG_imgS(imgSName);
		
		goodsService.goodsWrite(goodsDTO);
		
		return "redirect:/goods/form";
	}
	
}