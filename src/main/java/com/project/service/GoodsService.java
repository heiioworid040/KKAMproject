package com.project.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.project.dao.GoodsDAO;
import com.project.domain.BasketDTO;
import com.project.domain.GoodsDTO;
import com.project.domain.OrderDTO;

@Repository
public class GoodsService {
	
	@Inject
	private GoodsDAO goodsDAO;
	
	public List<GoodsDTO> goodsList(GoodsDTO goodsDTO) {
		return goodsDAO.goodsList(goodsDTO);
	}
	
	public List<GoodsDTO> goodsList(String G_code) {
		return goodsDAO.goodsList(G_code);
	}
	
	public List<BasketDTO> basketList(String id) {
		return goodsDAO.basketList(id);
	}
	
	public void basketPro(BasketDTO basketDTO) {
		if(goodsDAO.maxB_num()==null) {
			basketDTO.setB_num(1);
		}else {
			basketDTO.setB_num(goodsDAO.maxB_num()+1);
		}

		if(goodsDAO.getG_code(basketDTO)==null) {
			goodsDAO.basketAdd(basketDTO);
		}else {
			if(goodsDAO.maxB_count(basketDTO)!=null) {
				//제한 수량 이상 구매 시 제한
				basketDTO.setB_count(goodsDAO.maxB_count(basketDTO)+basketDTO.getB_count());
				goodsDAO.basketUpdate(basketDTO);
			}
		}
	}
	
	public void basketUpdate(BasketDTO basketDTO) {
		goodsDAO.basketUpdate(basketDTO);
	}
	
	public Integer basketAllPrice(String id) {
		return goodsDAO.basketAllPrice(id);
	}

	public void goodsWrite(GoodsDTO goodsDTO) {
		goodsDAO.goodsWrite(goodsDTO);
	}

	public void orderPro(OrderDTO orderDTO) {
//		orderDTO.setO_code(0); //주문날짜 O20230516000, string으로 변경, O_code=D_num 예정
		goodsDAO.orderAdd(orderDTO);
	}

//	public List<OrderDTO> orderList(OrderDTO orderDTO) {
//		return goodsDAO.orderList(orderDTO);
//	}
	
}