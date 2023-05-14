package com.project.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.project.dao.GoodsDAO;
import com.project.domain.BasketDTO;
import com.project.domain.GoodsDTO;

@Repository
public class GoodsService {
	
	@Inject
	private GoodsDAO goodsDAO;
	
	public List<GoodsDTO> goodsList(GoodsDTO goodsDTO) {
		return goodsDAO.goodsList(goodsDTO);
	}
	
	public List<BasketDTO> basketList(BasketDTO bagDTO) {
		return goodsDAO.basketList(bagDTO);
	}
	
	public void basketPro(BasketDTO bagDTO) {
		if(goodsDAO.maxB_num()==null) {
			bagDTO.setB_num(1);
		}else {
			bagDTO.setB_num(goodsDAO.maxB_num()+1);
		}

		if(goodsDAO.getG_code(bagDTO)==null) {
			goodsDAO.basketAdd(bagDTO);
		}else {
			if(goodsDAO.maxB_count(bagDTO)!=null) {
				//+1 대신 request.B_count 으로 수정 예정
				//제한 수량 이상 구매 시 제한
				bagDTO.setB_count(goodsDAO.maxB_count(bagDTO)+1);
			}
			goodsDAO.basketUpdate(bagDTO);
		}
	}

	public void goodsWrite(GoodsDTO goodsDTO) {
		goodsDAO.goodsWrite(goodsDTO);
	}
	
}