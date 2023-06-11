package com.project.controller;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.domain.BasketDTO;
import com.project.domain.GoodsDTO;
import com.project.domain.OrderDTO;
import com.project.service.GoodsService;

@Controller
public class GoodsController {
	
	@Inject
	private GoodsService goodsService;
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String today=sdf.format(System.currentTimeMillis());
	
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
	
	@RequestMapping(value = "/goods/basketPro", method = RequestMethod.POST)
	public String goodsbasketPro(HttpSession session, HttpServletRequest request, Model model) {
		String details=request.getParameter("details");
		String basket=request.getParameter("basket");
		String ck[]=request.getParameterValues("ck");
		
		
		BasketDTO basketDTO=new BasketDTO();
		basketDTO.setU_id((String)session.getAttribute("id"));
		basketDTO.setG_code(request.getParameter("G_code"));
		basketDTO.setB_count(Integer.parseInt(request.getParameter("count")));
		basketDTO.setB_date(Timestamp.valueOf(today));

		//basketPro로 중복 코드 제거 예정
		if(details!=null) {
			goodsService.basketPro(basketDTO);
		}else if(basket.equals("basketUp")) {
			goodsService.basketUpdate(basketDTO);
		}else if(basket.equals("basketDel")) {
			for(int i=0;i<ck.length;i++) {
				basketDTO.setG_code(ck[i]);
				goodsService.basketDel(basketDTO);
			}
		}else {
			goodsService.basketAllDel(basketDTO);
		}
		return "redirect:/goods/basket";
	}

	@RequestMapping(value = "/goods/order", method = RequestMethod.GET)
	public String goodsOrder(@RequestParam(value = "ck", required = false) List<String> ck, HttpSession session, HttpServletRequest request, Model model) {
		String details=request.getParameter("details");
		String basket=request.getParameter("basket");
		String id=(String)session.getAttribute("id");
		
		int count=0;
		int price=0;
		int delivery=0;
		
		if(details!=null) {
			String G_code=request.getParameter("G_code");
			count=Integer.parseInt(request.getParameter("count"));
			price=Integer.parseInt(request.getParameter("price"))*count;

			List<GoodsDTO> GoodsList=goodsService.goodsList(G_code);
			model.addAttribute("GoodsList", GoodsList);

			GoodsDTO goodsDTO=new GoodsDTO();
			goodsDTO.setG_code(request.getParameter(G_code));
		}else {
			List<BasketDTO> BasketList;
			if(basket.equals("order")) {
				BasketList=goodsService.basketList(id, ck);
			}else {
				BasketList=goodsService.basketList(id);
			}
			price=goodsService.basketAllPrice(id);
			count=goodsService.basketAllCount(id);
			
			model.addAttribute("GoodsList", BasketList);
		}
		
		if(price<100000) {
			delivery=2500;
		}
		
		//장바구니 리스트로 수정 예정
		model.addAttribute("details", details);
		model.addAttribute("count", count);
		model.addAttribute("price", price);
		model.addAttribute("delivery", delivery);
		return "goods/order";
	}
	
	@RequestMapping(value = "/goods/orderPro", method = RequestMethod.POST)
	public String goodsOrder(HttpSession session, HttpServletRequest request) {
		String order=request.getParameter("order");
		String[] G_code=request.getParameterValues("G_code");
		String[] ck=request.getParameterValues("ck");
		
		OrderDTO orderDTO=new OrderDTO();
		orderDTO.setU_id((String)session.getAttribute("id"));
		
		if(order!=null) {
			for(int i=0;i<ck.length;i++) {
				orderDTO.setG_code(ck[i]);
				goodsService.basketDel(orderDTO);
			}
			return "redirect:/goods/order";
		}else {
			orderDTO.setO_name(request.getParameter("O_name"));
			orderDTO.setO_phone(Integer.parseInt(request.getParameter("O_phone1")+request.getParameter("O_phone2")+request.getParameter("O_phone3")));
			orderDTO.setO_delivery(Integer.parseInt(request.getParameter("O_delivery")));
			orderDTO.setO_price(Integer.parseInt(request.getParameter("O_price")));
			orderDTO.setO_count(Integer.parseInt(request.getParameter("O_count")));
			orderDTO.setO_date(Timestamp.valueOf(today));
			//delivery
			orderDTO.setD_name(request.getParameter("D_name"));
			orderDTO.setD_address(request.getParameter("D_address"));
			orderDTO.setD_addressD(request.getParameter("D_addressD"));
			orderDTO.setD_zipcode(Integer.parseInt(request.getParameter("D_zipcode")));
			orderDTO.setD_phone(Integer.parseInt(request.getParameter("D_phone1")+request.getParameter("D_phone2")+request.getParameter("D_phone3")));
			orderDTO.setD_desc(request.getParameter("D_desc"));
	
			goodsService.orderAdd(orderDTO);
			//orderD 배열
			for(int i=0;i<G_code.length;i++) {
				String[] OD_price=request.getParameterValues("OD_price");
				String[] OD_count=request.getParameterValues("OD_count");
	
				orderDTO.setG_code(G_code[i]);
				orderDTO.setOD_price(Integer.parseInt(OD_price[i]));
				orderDTO.setOD_count(Integer.parseInt(OD_count[i]));
				goodsService.orderDAdd(orderDTO);
				goodsService.basketDel(orderDTO);
			}
			return "redirect:/goods/form";
		}
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