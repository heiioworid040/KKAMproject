package com.project.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.project.dao.GoodsDAO;
import com.project.domain.BasketDTO;
import com.project.domain.GoodsDTO;
import com.project.domain.LikeDTO;
import com.project.domain.OrderDTO;

@Repository
public class GoodsService {
//	중복 메서드 정리, 메서드 구분 예정
	@Inject
	private GoodsDAO goodsDAO;
	
	public List<GoodsDTO> goodsList(GoodsDTO goodsDTO) {
		return goodsDAO.goodsList(goodsDTO);
	}
	
	public List<GoodsDTO> goodsList(String G_code) {
		return goodsDAO.goodsList(G_code);
	}
	
	public GoodsDTO goods(String G_code) {
		return goodsDAO.goods(G_code);
	}
	
	public List<BasketDTO> basketList(String id) {
		return goodsDAO.basketList(id);
	}
	
	public List<BasketDTO> basketList(String id, List<String> ck) {
		return goodsDAO.basketList(id, ck);
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
	
	public void basketDel(BasketDTO basketDTO) {
		goodsDAO.basketDel(basketDTO);
	}
	
	public void basketAllDel(BasketDTO basketDTO) {
		goodsDAO.basketAllDel(basketDTO);
	}
	
	public Integer basketAllPrice(String id) {
		return goodsDAO.basketAllPrice(id);
	}
	
	public Integer basketAllCount(String id) {
		return goodsDAO.basketAllCount(id);
	}
	
	public List<OrderDTO> orderList(String id) {
		return goodsDAO.orderList(id);
	}
	
	public List<LikeDTO> likeList(String id) {
		return goodsDAO.likeList(id);
	}
	
	public String likeSelect(LikeDTO likeDTO) {
		return goodsDAO.likeSelect(likeDTO);
	}
	
	public void likeAdd(LikeDTO likeDTO) {
		if(goodsDAO.maxL_num()==null) {
			likeDTO.setL_num(1);
		}else {
			likeDTO.setL_num(goodsDAO.maxL_num()+1);
		}
		goodsDAO.likeAdd(likeDTO);
	}
	
	public void likeDel(LikeDTO likeDTO) {
		goodsDAO.likeDel(likeDTO);
	}
	
	public void orderAdd(OrderDTO orderDTO) {
		String num;
		if(goodsDAO.maxD_num()==null) {
			orderDTO.setD_num(1);
		}else {
			orderDTO.setD_num(goodsDAO.maxD_num()+1);
		}
		if(goodsDAO.maxO_code(orderDTO)==null) {
			num="001";
		}else {
			Integer max=goodsDAO.maxO_code(orderDTO);
			if(max<9) {
				num="00"+(max+1);
			}else if(max<99) {
				num="0"+(max+1);
			}else {
				num=""+(max+1);
			}
		}
		String date=(String.valueOf(orderDTO.getO_date()).substring(0,10).replace("-",""));
		orderDTO.setO_code(date+num);
		goodsDAO.orderAdd(orderDTO);
	}
	
	public void orderDAdd(OrderDTO orderDTO) {
		if(goodsDAO.maxOD_num()==null) {
			orderDTO.setOD_num(1);
		}else {
			orderDTO.setOD_num(goodsDAO.maxOD_num()+1);
		}
		orderDTO.setO_code(goodsDAO.getO_code(orderDTO));
		goodsDAO.orderDAdd(orderDTO);
	}

	public void goodsWrite(GoodsDTO goodsDTO) {
		goodsDAO.goodsWrite(goodsDTO);
	}
	
}