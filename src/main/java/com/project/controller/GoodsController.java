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
import com.project.domain.OrderDTO;
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
		List<GoodsDTO> GoodsList=goodsService.goodsList(request.getParameter("G_code"));
		
		model.addAttribute("GoodsList", GoodsList);
		return "goods/details";
	}
	
	@RequestMapping(value = "/goods/basket", method = RequestMethod.GET)
	public String goodsbasket(HttpSession session, Model model) {
		String id=(String)session.getAttribute("id");
		int delivery;
		
		List<BasketDTO> BasketList=goodsService.basketList(id);
		int price=goodsService.basketAllPrice(id);
		if(price>100000) {
			delivery=0;
		}else {
			delivery=2500;
		}
		
		model.addAttribute("BasketList", BasketList);
		model.addAttribute("price", price);
		model.addAttribute("delivery", delivery);
		return "goods/basket";
	}
	
	@RequestMapping(value = "/goods/basketPro", method = RequestMethod.GET)
	public String goodsbasketPro(HttpSession session, HttpServletRequest request, Model model) {
//		BasketDTO bagDTO=new BasketDTO();
//		bagDTO.setU_id((String)session.getAttribute("id"));
//		bagDTO.setG_code(request.getParameter("G_code"));
//		bagDTO.setB_count(Integer.parseInt(request.getParameter("count")));
//
//		goodsService.basketPro(bagDTO);
//		System.out.println(session.getAttribute("id"));
//		System.out.println(request.getParameter("G_code"));
//		System.out.println(request.getParameter("count"));
		return "redirect:/goods/basket";
	}

	@RequestMapping(value = "/goods/order", method = RequestMethod.GET)
	public String goodsOrder(HttpSession session, HttpServletRequest request, Model model) {
		String order=request.getParameter("order");
		String id=(String)session.getAttribute("id");

		int price=0;
		int delivery=0;
		
		if(order.equals("details")) {
			String G_code=request.getParameter("G_code");
			int OD_count=Integer.parseInt(request.getParameter("count"));

			List<GoodsDTO> GoodsList=goodsService.goodsList(G_code);
			model.addAttribute("GoodsList", GoodsList);
			model.addAttribute("OD_count", OD_count);

			GoodsDTO goodsDTO=new GoodsDTO();
			goodsDTO.setG_code(request.getParameter(G_code));
		} else {
			System.out.println("전체구매");
			List<BasketDTO> BasketList=goodsService.basketList(id);
			price=goodsService.basketAllPrice(id);
			
			if(price<100000) {
				delivery=2500;
			}
			model.addAttribute("GoodsList", BasketList);
		}
		
		
		//장바구니 리스트로 수정 예정
		model.addAttribute("price", price);
		model.addAttribute("delivery", delivery);
		return "goods/order";
	}
	
	@RequestMapping(value = "/goods/orderPro", method = RequestMethod.GET)
	public String goodsOrder(HttpSession session, HttpServletRequest request) {
		OrderDTO orderDTO=new OrderDTO();
		orderDTO.setU_id((String)session.getAttribute("id"));
		orderDTO.setO_name(request.getParameter("O_name"));
		orderDTO.setO_phone(Integer.parseInt(request.getParameter("O_phone")));
		orderDTO.setO_delivery(Integer.parseInt(request.getParameter("O_delivery")));
		orderDTO.setO_price(Integer.parseInt(request.getParameter("O_price")));
		orderDTO.setO_count(Integer.parseInt(request.getParameter("O_count")));
		//orderD 배열
		orderDTO.setG_code(request.getParameter("G_code"));
		orderDTO.setOD_price(Integer.parseInt(request.getParameter("OD_price")));
		orderDTO.setOD_count(Integer.parseInt(request.getParameter("OD_count")));
		//delivery
		orderDTO.setD_name(request.getParameter("D_name"));
		orderDTO.setD_address(request.getParameter("D_address"));
		orderDTO.setD_addressD(request.getParameter("D_addressD"));
		orderDTO.setD_zipcode(Integer.parseInt(request.getParameter("D_zipcode")));
		orderDTO.setD_phone(Integer.parseInt(request.getParameter("D_phone")));
		orderDTO.setD_desc(request.getParameter("D_desc"));
		
		goodsService.orderPro(orderDTO);
		
		return "redirect:/goods/form";
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