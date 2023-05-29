package com.project.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.domain.BasketDTO;
import com.project.domain.BasketDTO.BasketQuery;
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
	
	
	public List<BasketDTO> basketList(String id, List<String> ck) {
		BasketQuery query = new BasketQuery(id, ck);
		return sqlSession.selectList(namespace+".basketCkList", query);
	}
	
	public void basketAdd(BasketDTO basketDTO) {
		sqlSession.insert(namespace+".basketAdd", basketDTO);
	}
	
	public void basketUpdate(BasketDTO basketDTO) {
		sqlSession.update(namespace+".basketUpdate", basketDTO);
	}

	public Integer basketAllPrice(String id) {
		return sqlSession.selectOne(namespace+".basketAllPrice", id);
	}
	
	public Integer basketAllCount(String id) {
		return sqlSession.selectOne(namespace+".basketAllCount", id);
	}
	
	public void orderAdd(OrderDTO orderDTO) {
		sqlSession.insert(namespace+".ordersAdd", orderDTO);
		sqlSession.insert(namespace+".deliveryAdd", orderDTO);
	}
	
	public void orderDAdd(OrderDTO orderDTO) {
		sqlSession.insert(namespace+".ordersDAdd", orderDTO);
	}
	
	public void basketDel(BasketDTO basketDTO) {
		sqlSession.delete(namespace+".basketDel", basketDTO);
	}
	
	public void basketAllDel(BasketDTO basketDTO) {
		sqlSession.delete(namespace+".basketAllDel", basketDTO);
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
	
	public Integer maxOD_num() {
		return sqlSession.selectOne(namespace+".maxOD_num");
	}
	
	public Integer maxD_num() {
		return sqlSession.selectOne(namespace+".maxD_num");
	}
	
	public String getO_code(OrderDTO orderDTO) {
		return sqlSession.selectOne(namespace+".getO_code", orderDTO);
	}
	
	public Integer maxO_code(OrderDTO orderDTO) {
		return sqlSession.selectOne(namespace+".maxO_code", orderDTO);
	}
}
