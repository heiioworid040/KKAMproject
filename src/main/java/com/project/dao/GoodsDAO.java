package com.project.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.domain.BasketDTO;
import com.project.domain.GoodsDTO;
import com.project.domain.OrderDTO;

@Repository
public class GoodsDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.project.mappers.goodsMapper";
	
	public List<GoodsDTO> goodsList(GoodsDTO goodsDTO) {
		return sqlSession.selectList(namespace+".goodsList", goodsDTO);
	}
	
	public List<GoodsDTO> goodsList(String G_code) {
		return sqlSession.selectList(namespace+".goodsDetail", G_code);
	}
	
	public List<BasketDTO> basketList(String id) {
		return sqlSession.selectList(namespace+".basketList", id);
	}
	
	public void basketAdd(BasketDTO basketDTO) {
		System.out.println("DAO");
		sqlSession.insert(namespace+".basketAdd", basketDTO);
	}
	
	public void basketUpdate(BasketDTO basketDTO) {
		sqlSession.update(namespace+".basketUpdate", basketDTO);
	}

	public Integer basketAllPrice(String id) {
		return sqlSession.selectOne(namespace+".basketAllPrice", id);
	}
	
	public void goodsWrite(GoodsDTO goodsDTO) {
		sqlSession.insert(namespace+".goodsWrite", goodsDTO);
	}

	public Integer maxB_num() {
		return sqlSession.selectOne(namespace+".maxB_num");
	}
	
	public Integer maxB_count(BasketDTO basketDTO) {
		return sqlSession.selectOne(namespace+".maxB_count", basketDTO);
	}
	
	public String getG_code(BasketDTO basketDTO) {
		return sqlSession.selectOne(namespace+".getG_code", basketDTO);
	}

	public void orderAdd(OrderDTO orderDTO) {
		sqlSession.insert(namespace+".orderAdd", orderDTO);
	}

}
